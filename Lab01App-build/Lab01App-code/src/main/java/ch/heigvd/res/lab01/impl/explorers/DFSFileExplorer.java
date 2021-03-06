package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits all
 * files in the directory and then moves into the subdirectories.
 *
 * @author Olivier Liechti
            Modified by Tano Iannetta
 */
public class DFSFileExplorer implements IFileExplorer {

  @Override
  public void explore(File rootDirectory, IFileVisitor visitor) {

      visitor.visit(rootDirectory); // get name

      if (rootDirectory.isDirectory())
      {

          File [] files = rootDirectory.listFiles();
          ArrayList<File> subdirectories = new ArrayList<>();
          Arrays.sort(files); // sort files

          for(File file : files) // course
          {
              if(file.isDirectory())
              {
                  subdirectories.add(file);
              }
              else
              {
                  explore(file, visitor);
              }
          }

          for (File subdirectorie : subdirectories)
          {
              explore(subdirectorie, visitor);
          }
      }

  }

}
