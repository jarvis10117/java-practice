package exceptions_handling;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class InstantPiano extends JFrame implements KeyListener {
    private Synthesizer synth;
    private Receiver receiver;

    // Maps the keyboard key code to its corresponding MIDI note value
    private final Map<Integer, Integer> keyToNoteMap = new HashMap<>();

    // Tracks the active pressed state of each key independently to block OS auto-repeat
    private final Map<Integer, Boolean> keyStateMap = new HashMap<>();

    public InstantPiano() {
        setTitle("Java MIDI Piano (Keys 1-7)");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setLocationRelativeTo(null);
        setVisible(true);

        // Initialize MIDI
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            receiver = synth.getReceiver();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        // Initialize the musical scale maps (Key -> MIDI Note)
        // 60 is Middle C (Do), 71 is B (Ti)
        keyToNoteMap.put(KeyEvent.VK_1, 60); // Do (C)
        keyToNoteMap.put(KeyEvent.VK_2, 62); // Re (D)
        keyToNoteMap.put(KeyEvent.VK_3, 64); // Mi (E)
        keyToNoteMap.put(KeyEvent.VK_4, 65); // Fa (F)
        keyToNoteMap.put(KeyEvent.VK_5, 67); // So (G)
        keyToNoteMap.put(KeyEvent.VK_6, 69); // La (A)
        keyToNoteMap.put(KeyEvent.VK_7, 71); // Ti (B)

        // Set all tracked keys to false (not pressed) initially
        for (Integer key : keyToNoteMap.keySet()) {
            keyStateMap.put(key, false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Only handle keys 1 through 7
        if (keyToNoteMap.containsKey(keyCode)) {
            // Ignore OS auto-repeat if the key is already physically down
            if (keyStateMap.get(keyCode)) {
                return;
            }

            // Mark this specific key as pressed
            keyStateMap.put(keyCode, true);
            int note = keyToNoteMap.get(keyCode);

            try {
                ShortMessage msg = new ShortMessage();
                msg.setMessage(ShortMessage.NOTE_ON, 0, note, 100);
                receiver.send(msg, -1);
            } catch (InvalidMidiDataException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyToNoteMap.containsKey(keyCode)) {
            // Reset state for this specific key
            keyStateMap.put(keyCode, false);
            int note = keyToNoteMap.get(keyCode);

            try {
                ShortMessage msg = new ShortMessage();
                msg.setMessage(ShortMessage.NOTE_OFF, 0, note, 0);
                receiver.send(msg, -1);
            } catch (InvalidMidiDataException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InstantPiano::new);
    }
}
