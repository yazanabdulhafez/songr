package com.ASAC.songr.Controllers;

import com.ASAC.songr.Models.Album;
import com.ASAC.songr.Models.Song;
import com.ASAC.songr.repository.AlbumRepository;
import com.ASAC.songr.repository.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    SongsRepository songsRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/allsongs")
    public String getAllSongs(Model model){
        model.addAttribute("songs",songsRepository.findAll());
        return "songs";
    }

    @GetMapping("/songsError")
    public String songErrorHandler(){
        return "errorSong";
    }

    @GetMapping("/addSongsForm")
    public String songForm(Model model) {
        model.addAttribute("songs", new Song());
        return "oneAlbum";
    }


    @PostMapping("/addSongsForm")
    public String  addSongForm(@ModelAttribute Song song, Model model) {
        try {
            songsRepository.save(song);
            model.addAttribute("songs", song);
                return "/oneAlbum?id="+song.getId() ;
        }catch (Exception exception){
            return "errorSong";
        }
    }


}
