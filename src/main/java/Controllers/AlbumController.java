package Controllers;


import Models.Albums;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {

    @GetMapping("/albums")
    public String albums(Model model){
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
        return "albums";

    }
}
