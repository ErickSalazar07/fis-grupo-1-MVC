package co.musicshop.fis.controllers;

import co.musicshop.fis.dtos.CreateSongDto;
import co.musicshop.fis.models.Song;
import co.musicshop.fis.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping()
    public String allSongs(Model model) {

        List<Song> songs = songService.findAllSongs();

        model.addAttribute("songs", songs);

        return "songs"; // Refers to songs.html (view)
    }

    @GetMapping("/add")
    public String addSongForm(Model model) {
        model.addAttribute("createSongDto", new CreateSongDto());
        return "addSong"; // Refers to add.html (view)
    }


    @PostMapping("/songs/add")
    public String addSong(@ModelAttribute("createSongDto") CreateSongDto createSongDto, Model model) {
        // You can convert DTO to entity and process/save the song
        Song song = new Song(
                createSongDto.getTitle(),
                createSongDto.getArtist(),
                createSongDto.getGenre(),
                createSongDto.getYear(),
                createSongDto.getAlbum(),
                createSongDto.getAlbumCover(),
                createSongDto.getDuration()
        );

        // Save the song
        songService.saveSong(song);

        // Pass the song entity back to the view
        model.addAttribute("song", song);

        return "redirect:/songs"; // Redirect to /songs
    }

    @GetMapping("/{songId}/update")
    public String updateSongForm(@PathVariable("songId") long songId, Model model) {
        Song song = songService.findSongById(songId);
        model.addAttribute("song", song);
        return "updateSong";
    }

    @PostMapping("/{songId}/update")
    public String updateSong(@PathVariable("songId") long songId, @ModelAttribute("song") Song song) {
        song.setId(songId);
        songService.updateSong(song);
        return "redirect:/songs";
    }

    @GetMapping("/{songId}/delete")
    public String deleteSong(@PathVariable("songId") long songId) {
        songService.deleteSong(songId);
        return "redirect:/songs";
    }

}
