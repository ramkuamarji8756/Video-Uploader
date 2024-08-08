package com.stream.app.controller;
import com.stream.app.entity.Video;
import com.stream.app.palyload.CustomMessage;
import com.stream.app.services.VideoServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/videos")
@CrossOrigin("*")
public class VideoController
{
	
	 private VideoServices videoService;

	    public VideoController(VideoServices videoService) {
	        this.videoService = videoService;
	    }

	    @PostMapping
	    public ResponseEntity<?> create(
	            @RequestParam("file") MultipartFile file,
	            @RequestParam("title") String title,
	            @RequestParam("description") String description
	    ) {

	        Video video = new Video();
	        video.setTitle(title);
	        video.setDescription(description);
	        video.setVideoId(UUID.randomUUID().toString());

	        Video savedVideo = videoService.save(video, file);

	        if (savedVideo != null) {
	            return ResponseEntity
	                    .status(HttpStatus.OK)
	                    .body(video);
	        } else {
	            return ResponseEntity
	                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body(CustomMessage.builder()
	                            .message("Video not uploaded ")
	                            .success(false)
	                            .build()
	                    );
	        }


	    }
}
