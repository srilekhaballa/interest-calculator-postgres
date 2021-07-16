/*
 * package com.example.interestcalculatorpostgres.controller;
 * 
 * import java.io.IOException; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.RequestEntity.BodyBuilder; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import com.example.interestcalculatorpostgres.dao.Image; import
 * com.example.interestcalculatorpostgres.dao.ImageRepository;
 * 
 * @RestController
 * 
 * @CrossOrigin(origins = "http://localhost:4200")
 * 
 * @RequestMapping(path = "image") public class ImageUploadController {
 * 
 * @Autowired ImageRepository imageRepository;
 * 
 * @PostMapping("/upload") public BodyBuilder
 * uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException
 * {
 * 
 * 
 * System.out.println("Original Image Byte Size - " + file.getBytes().length);
 * 
 * Image img = new Image(file.getOriginalFilename(), file.getContentType(),
 * 
 * compressBytes(file.getBytes()));
 * 
 * imageRepository.save(img);
 * 
 * return ResponseEntity.status(HttpStatus.OK);
 * 
 * }
 * 
 * 
 * @GetMapping(path = { "/getimage" })
 * 
 * public Image getImage(@PathVariable("imageName") String name) throws
 * IOException {
 * 
 * final Optional<Image> retrievedImage = imageRepository.findByName(name);
 * 
 * Image img = new Image(retrievedImage.get().getName(),
 * retrievedImage.get().getType(),
 * 
 * decompressBytes(retrievedImage.get().getPicByte()));
 * 
 * return img;
 * 
 * } }
 */