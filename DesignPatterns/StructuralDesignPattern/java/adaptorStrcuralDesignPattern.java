package DesignPatterns.StructuralDesignPattern.java;


/*
* Adapter: This pattern allows incompatible interfaces to work together by converting the interface of one class to a format that another class expects.

 */
public class adaptorStrcuralDesignPattern {

    interface LegacyMediaPlayer {
        void playLegacyFormat(String fileName);
    }

    interface ModernMediaPlayer {
        void play(String fileName);
    }

    static class LegacyMediaPlayerAdapter implements ModernMediaPlayer {
        private LegacyMediaPlayer legacyPlayer;

        public LegacyMediaPlayerAdapter(LegacyMediaPlayer player) {
            this.legacyPlayer = player;
        }

        @Override
        public void play(String fileName) {
            legacyPlayer.playLegacyFormat(fileName + ".legacy"); // Adapt format
        }
    }
}


