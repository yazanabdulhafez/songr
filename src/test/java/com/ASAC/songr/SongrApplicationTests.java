package com.ASAC.songr;

import com.ASAC.songr.Models.Albums;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SongrApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void albumClassTest() {
        String imageUrl = "http://www.popvortex.com/images/album-covers/whte-album-the-beatles.jpg";
        Albums testAlbum = new Albums("White Album", "The Beatles", 30, 5613, imageUrl);
        //test for the constructor
        assertTrue(testAlbum instanceof Albums);
        testAlbum.setArtist("Kazem Al Saher");
        testAlbum.setTitle("Al Rasm Bel Kalemat");
        testAlbum.setSongCount(9);
        testAlbum.setLength(3063);
        testAlbum.setImageUrl("http://melody4arab.com/music/iraq/kadim_al_sahir/al_rasm_bel_kalemat/Al-Rasm-Bel-Kalemat.jpg");

        //test for Artist
        assertEquals("Kazem Al Saher", testAlbum.getArtist());
        //test for Title
        assertEquals("Al Rasm Bel Kalemat", testAlbum.getTitle());
        //test for songCount
        assertEquals(9, testAlbum.getSongCount());
        //test for length in seconds
        assertEquals(3063, testAlbum.getLength());
        //test for image url
		String testUrl="http://melody4arab.com/music/iraq/kadim_al_sahir/al_rasm_bel_kalemat/Al-Rasm-Bel-Kalemat.jpg";
        assertEquals(testUrl, testAlbum.getImageUrl());
    }

}
