package exceptions_handling;

import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class MiniMiniMusicApp {
    // Keep a single sequencer instance for the entire app
    private Sequencer player;

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();

        // Initialize and open the sequencer once before the loop starts
        mini.initSequencer();

        for (int i = 1; i <= 10; i++) {
            mini.play();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Loop was interrupted");
            }
        }

        // Clean up and close the sequencer when done
        mini.closeSequencer();
    }

    public void initSequencer() {
        try {
            player = MidiSystem.getSequencer();
            player.open(); // Opened ONCE here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            // Sequence and Track setup is fast and can stay here
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(NOTE_ON, 1, 44, 100);
            MidiEvent noteOn = new MidiEvent(msg1, 1);
            track.add(noteOn);

            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(NOTE_OFF, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(msg2, 16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeSequencer() {
        if (player != null && player.isOpen()) {
            player.close();
        }
    }
}
