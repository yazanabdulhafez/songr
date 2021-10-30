package com.ASAC.songr.Controllers;


import com.ASAC.songr.Models.Album;
import com.ASAC.songr.Models.Song;
import com.ASAC.songr.repository.AlbumRepository;
import com.ASAC.songr.repository.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongsRepository songsRepository;

    @GetMapping
    public String errorhandler(){
      return "error";
    }


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
        try {
            Album album = new Album(title, artist, songCount, length, imageUrl);
            albumRepository.save(album);
            return new RedirectView("/albums");
        } catch (Exception exception){
        System.out.println(exception);
        return new RedirectView("/error");
    }
    }

    @GetMapping("/addAlbumsForm")
    public String albumForm(Model model) {
        model.addAttribute("albums", new Album());
        return "addNewAlbum";
    }


    @PostMapping("/addAlbumsForm")
    public String addAlbumsForm(@ModelAttribute Album album, Model model) {
        try {
        albumRepository.save(album);
        model.addAttribute("albums", album);
        return "result";
    } catch (Exception exception){
        return "error";
    }
    }

    @GetMapping("/oneAlbum")
    public String getOneAlbum(@RequestParam Integer id , Model model){
        Album albumToShow = albumRepository.findById(id).get();
        model.addAttribute("albums" , albumToShow);
        List<Song> albumSongs = songsRepository.findAllByAlbum(albumToShow);
        model.addAttribute("songs" , albumSongs);
        return "oneAlbum";
    }


    /*
@RequestParam(value= "title") String title ,
                                 @RequestParam(value= "artist") String artist,
                                 @RequestParam(value="songCount") int songCount,
                                 @RequestParam(value="length") int length,
                                 @RequestParam(value="imageUrl") String imageUrl){
        Album albums=new Albums(title,artist,songCount,length,imageUrl
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

                 Album whiteAlbum=new Album("White Album","The Beatles",	30
                    ,5613,
                    "http://www.popvortex.com/images/album-covers/whte-album-the-beatles.jpg");
            albumRepository.save(whiteAlbum);
            Album revolverAlbum=new Album("Revolver ","The Beatles",	14
                    ,2083,
                    "http://www.popvortex.com/images/album-covers/revolver-the-beatles.jpg");
            albumRepository.save(revolverAlbum);
            Album thrillerAlbum=new Album("Thriller  Album","Michael Jackson",	9
                    ,5613,
                    "http://www.popvortex.com/images/album-covers/thriller.jpg");
            albumRepository.save(thrillerAlbum);
     */
}
