package com.ASAC.songr.Controllers;


import com.ASAC.songr.Models.Albums;
import com.ASAC.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String albums(Model model){
        model.addAttribute("albums" ,albumRepository.findAll());
        return "albums";
    }

    @RequestMapping(value="/addAlbum", method = RequestMethod.POST)
//    @PostMapping("/addAlbum") // this should be a post.
    public RedirectView addAlbum(@RequestParam(value= "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="length") int length,
                                 @RequestParam(value="imageUrl") String imageUrl){
        Albums albums=new Albums(title,artist,songCount,length,imageUrl);

        albumRepository.save(albums);
        return new RedirectView("/albums");
    }

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
