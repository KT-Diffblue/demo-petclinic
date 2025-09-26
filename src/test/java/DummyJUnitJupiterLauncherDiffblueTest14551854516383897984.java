import java.io.File;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("DefaultPackage")
class DummyJUnitJupiterLauncherDiffblueTest14551854516383897984 {

  /**
   * This test prints the junit launcher jar location to the file
   * /system_temp_dir/DummyJUnitJupiterLauncherDiffblueTestXXXXX.tmp and this file persists for the
   * JunitJupiterLauncherDetector to read and use.
   *
   * @throws Exception any exception
   */
  @Test
  void testPrintLauncherPath() throws Exception {
    String className = "org.junit.platform.launcher.Launcher";
    try {
      String launcherJar =
        new File(
          Class.forName(className)
            .getProtectionDomain()
            .getCodeSource()
            .getLocation()
            .toURI())
          .toString();

      Path tmpPath = Paths.get("/var/folders/nw/fp0lpfl90cd47wk9w1t8w8240000gp/T/DummyJUnitJupiterLauncherDiffblueTest14551854516383897984.tmp");
      try (OutputStreamWriter fileWriter =
             new OutputStreamWriter(Files.newOutputStream(tmpPath), StandardCharsets.UTF_8)) {
        fileWriter.write(launcherJar);
      }
    } catch (ClassNotFoundException | LinkageError e) {
      Assertions.fail("[NOT FOUND] " + className, e);
    }
  }
}