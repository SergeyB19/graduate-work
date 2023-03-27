package pro.sky.java.graduatework.homework.dto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.java.graduatework.homework.controller.AdsEntity;
import pro.sky.java.graduatework.homework.repositories.Repository;
import java.io.IOException;
import java.util.UUID;

public class Image {
    private MultipartFile file;
    private AdsEntity entity;

    // ниже код для примера сохранения картинки в БД
    @PostMapping("/upl")
    public String saveAds(@RequestParam MultipartFile image) {
        AdsEntity entity = new AdsEntity();
        try {
            // код, который кладет картинку в entity
            byte[] bytes = file.getBytes();
            entity.setImage(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        entity.setId(UUID.randomUUID().toString());
        // код сохранения картинки в БД
        AdsEntity savedEntity = Repository.saveAndFlush(entity);
        return savedEntity.getId();
    }

    // produces в аннотации GetMapping нужно указать для того, чтобы браузер понимал, что передается картинка
    @GetMapping(value = "/images/{id}/", produces = {MediaType.IMAGE_PNG_VALUE})
    public byte[] getImage(@PathVariable String id) {

        return entity.getImage();
    }

}
