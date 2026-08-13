package exceptions_handling;

import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
            mini.play();


    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(NOTE_ON, 1, 44, 90);
            MidiEvent noteOn = new MidiEvent(msg1, 4);
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(NOTE_OFF, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
            Thread.sleep(5000);
            player.close();
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}