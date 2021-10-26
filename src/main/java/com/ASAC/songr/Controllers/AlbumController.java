package com.ASAC.songr.Controllers;


import com.ASAC.songr.Models.Albums;
import com.ASAC.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;


@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String albums(Model model){
        model.addAttribute("albums" ,albumRepository.findAll());
        return "albums";
    }



    @RequestMapping(value = "/addAlbums", method = {RequestMethod.GET, RequestMethod.POST})

    public RedirectView addAlbum(@RequestParam(value= "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="length") int length,
                                 @RequestParam(value="imageUrl") String imageUrl){
      Albums albums=new Albums(title,artist,songCount,length,imageUrl);
              albumRepository.save(albums);
        return new RedirectView("/albums");
    }

    @GetMapping("/addAlbumsForm")
    public String albumForm(Model model) {
        model.addAttribute("albums", new Albums());
        return "form";
    }


    @PostMapping("/addAlbumsForm")
    public String addAlbumsForm(@ModelAttribute Albums albums, Model model) {
        albumRepository.save(albums);
        model.addAttribute("albums", albums);
        return "result";
    }

    /*
@RequestParam(value= "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="length") int length,
                                 @RequestParam(value="imageUrl") String imageUrl){
        Albums albums=new Albums(title,artist,songCount,length,imageUrl
 */

    /*
      ArrayList<Albums> albums=new ArrayList<>();
        Albums whiteAlbum=new Albums("White Album","The Beatles",	30
                ,5613,
                "http://www.popvortex.com/images/album-covers/whte-album-the-beatles.jpg");
        albums.add(whiteAlbum);
        Albums revolverAlbum=new Albums("Revolver ","The Beatles",	14
                ,2083,
                "http://www.popvortex.com/images/album-covers/revolver-the-beatles.jpg");
        albums.add(revolverAlbum);
        Albums thrillerAlbum=new Albums("Thriller  Album","Michael Jackson",	9
                ,5613,
                "http://www.popvortex.com/images/album-covers/thriller.jpg");
        albums.add(thrillerAlbum);
        model.addAttribute("albums",albums);

         Albums album1 = new Albums("new day","50 cent",	5
                ,3524,
                "https://upload.wikimedia.org/wikipedia/en/2/2a/50CentNewDay.jpg");
     */
}
