package com.lmg.cursomc.service;

import com.lmg.cursomc.service.exception.FileException;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImagemService {

    public BufferedImage getJpgImageFromFile(MultipartFile uploadedFile) {
        String extension = FilenameUtils.getExtension(uploadedFile.getOriginalFilename());

        if (!"png".equals(extension) && !"jpg".equals(extension)) {
            throw new FileException("Somente imagens PNG E JPG são permitidas");
        }
        try {
            BufferedImage img = ImageIO.read(uploadedFile.getInputStream());

            if ("png".equals(extension)) {
                img = pngToJpg(img);
            }
            return img;
        } catch (IOException e) {
            throw new FileException("Erro ao ler arquivo");
        }

    }

    /**
     * Converte imagem do tipo PNG para JPG
     * @param img Imagem recebida
     * @return
     */
    public BufferedImage pngToJpg(BufferedImage img) {
        BufferedImage jpgImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        jpgImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
        return jpgImage;
    }

    public InputStream getInputStream(BufferedImage img, String extesion) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(img, extesion, os);
            return new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            throw new FileException("Erro ao ler arquivo");
        }
    }

    /**
     * Método para recortar uma imagem
     *
     * @param sourceImg imagem original
     * @return retorna a imagem recortada
     */
    public BufferedImage cropSquare(BufferedImage sourceImg){
        int min = (sourceImg.getHeight() <= sourceImg.getWidth()) ? sourceImg.getHeight() : sourceImg.getWidth();
        return Scalr.crop(
            sourceImg,
                (sourceImg.getWidth()/2) - (min/2),
                (sourceImg.getHeight()/2) - (min/2),
                min,
                min);
    }

    /**
     * Redimensiona uma imagem
     * @param sourceImg
     * @param size
     * @return
     */
    public BufferedImage resize(BufferedImage sourceImg, int size){
        return Scalr.resize(sourceImg, Scalr.Method.ULTRA_QUALITY, size);
    }
}
