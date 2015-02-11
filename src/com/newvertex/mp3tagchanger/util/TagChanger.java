package com.newvertex.mp3tagchanger.util;

import com.newvertex.mp3tagchanger.model.Tags;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class TagChanger {

    private TagChanger() {
    }

    public static void ChangeTags(ArrayList<Path> files, Tags tags) {
        files.forEach(file -> {
            changeTag(file.toFile(), tags);
        });
    }

    public static void changeTag(File file, Tags tags) {
        AudioFile audioFile;
        try {
            audioFile = AudioFileIO.read(file);
            Tag tag = audioFile.getTag();

            tag.setField(FieldKey.TITLE, tags.getTitle());
            tag.setField(FieldKey.SUBTITLE, tags.getSubTitle());
            tag.setField(FieldKey.COMMENT, tags.getComment());
            tag.setField(FieldKey.COMPOSER, tags.getComposer());
            tag.setField(FieldKey.ALBUM, tags.getAlbum());
            tag.setField(FieldKey.ALBUM_ARTIST, tags.getAlbumArtist());
            tag.setField(FieldKey.ARTIST, tags.getArtist());
            tag.setField(FieldKey.ARTISTS, tags.getArtists());

            audioFile.commit();

        } catch (Exception ex) {
            Logger.getLogger(TagChanger.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" +" + file);
    }

}
