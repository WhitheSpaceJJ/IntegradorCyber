
package imagen;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;

public class ImagenPrueba {

 

    public static void main(String[] args) throws IOException {
        String origen = "C:\\Users\\josej\\OneDrive\\Escritorio\\imagenes\\inviernotemporada.jpeg";
        String rutaFinal = "C:\\Users\\josej\\OneDrive\\Escritorio\\imagencopia";

        File sourceFile = new File(origen);
        File destinationDirectory = new File(rutaFinal);

        File destinationFile = new File(destinationDirectory, sourceFile.getName());

        try {
            Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Imagen copiada con éxito.");
        } catch (IOException e) {
            System.out.println("Error al copiar la imagen: " + e.getMessage());
        }

        try {
            // Leer la imagen
            BufferedImage image = ImageIO.read(destinationFile);

            // Obtener el ancho y alto original de la imagen
            int width = image.getWidth();
            int height = image.getHeight();

            // Reducir la imagen a la mitad en píxeles
            int newWidth = width / 10;
            int newHeight = height / 10;
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = resizedImage.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(image, 0, 0, newWidth, newHeight, null);
            g.dispose();

            // Guardar la imagen reducida
            ImageIO.write(resizedImage, "jpeg", new File(destinationDirectory, "imagen_reducida.jpeg"));

            System.out.println("Imagen guardada como JPEG con éxito.");
        } catch (IOException e) {
            System.out.println("Error al guardar la imagen: " + e.getMessage());
        }
    }

}
