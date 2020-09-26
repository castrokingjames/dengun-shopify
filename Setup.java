import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Setup {

    private static final String MODULES[] = {
            "di/module",
            "di/scope",
            "ui/common",
            "ui/mvrx",
            "ui/navigation",
            "buildSrc",
            "data",
            "datasources/local",
            "datasources/remote",
            "domain",
            "features/user-list",
            "features/user-detail",
            "manager",
            "managers/android-dispatcher",
            "template"
    };

    private static final String PACKAGE_DIRECTORIES[] = {
            "di/module/src/main/kotlin/package", 
            "di/scope/src/main/kotlin/package", 
            "ui/common/src/main/kotlin/package", 
            "ui/mvrx/src/main/kotlin/package", 
            "ui/navigation/src/main/kotlin/package", 
            "buildSrc/src/main/java/package",
            "data/src/main/kotlin/package", 
            "datasources/local/src/main/kotlin/package", 
            "datasources/remote/src/main/kotlin/package", 
            "domain/src/main/kotlin/package", 
            "features/user-list/src/main/kotlin/package", 
            "features/user-detail/src/main/kotlin/package", 
            "manager/src/main/kotlin/package",
            "managers/android-dispatcher/src/main/kotlin/package",
            "template/src/main/kotlin/package"
    };

    public static void main(String args[]) throws Exception {
        if (args.length < 2) {
            displayUsage();
            return;
        }
        String packageName = null;
        String projectName = null;
        for (String arg : args) {
            if (arg.startsWith("-Dpackage-name=" )) {
                packageName = arg.split("=")[1];
            }

            if (arg.startsWith("-Dproject-name=" )) {
                projectName = arg.split("=")[1];
            }
        }

        if (packageName == null || projectName == null) {
            displayUsage();
            return;
        }

        System.out.println("Creating project " + projectName);

        replacePackageName(packageName);
        replaceProjectName(projectName);
        moveFileDirectory(packageName);
        replaceTemplate(projectName);

        System.out.println("Run 'gradlew assembleDebug' to ensure that everything works correctly.");
    }

    public static void displayUsage() { 
        System.out.println("Usage: java Setup -Dpackage-name=com.example.project -Dproject-name=Project");
    }

    public static void replacePackageName(String packageName) throws Exception {
        for (String module : MODULES) {
            List<File> files = ls(new File(module));
            for (File file : files) {
                replace(file, "@{PACKAGE_NAME}", packageName);
            }
        }
        replace(new File("build.gradle"), "@{PACKAGE_NAME}", packageName);
    }

    public static void replaceTemplate(String projectName) throws Exception {
        List<File> template = ls(new File("template"));
        for (File file : template) {
            String name = file.getName();
            if (name.startsWith("Template")) {
                String fileName = name.replace("Template", projectName);
                Path path = file.toPath();
                Files.move(path, path.resolveSibling(fileName));
            }
        }
        mv("template", projectName.toLowerCase());
    }

    public static void replaceProjectName(String projectName) throws Exception {
        List<File> template = ls(new File("template"));
        for (File file : template) {
            replace(file, "@{PROJECT_NAME}", projectName);
        }
        List<File> common = ls(new File("ui/common"));
        for (File file : template) {
            replace(file, "@{PROJECT_NAME}", projectName);
        }
        replace(new File("settings.gradle"), "@{PROJECT_NAME}", projectName.toLowerCase());
    }

    public static void moveFileDirectory(String packageName) throws Exception {
        String directory = packageName.replace(".", "/");

        for (String pkg : PACKAGE_DIRECTORIES) {
            String from = pkg;
            String to = from + "/../" + directory + "/";
            mv(from, to);
        }
    }

    public static void replace(File file, String pattern, String text) throws Exception {
        Path path = file.toPath();
        Charset charset = StandardCharsets.UTF_8;

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replace(pattern, text);
        Files.write(path, content.getBytes(charset));
    }

    public static List<File> ls(File directory) {
        List<File> list = new ArrayList<File>();
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                list.addAll(ls(file));
            } else {
                list.add(file);
            }
        }
        return list;
    }

    public static void mv(String from, String to) throws Exception {
        new File(to).mkdirs();
        Files.move(
                Paths.get(from),
                Paths.get(to),
                StandardCopyOption.REPLACE_EXISTING
        );
    }
}