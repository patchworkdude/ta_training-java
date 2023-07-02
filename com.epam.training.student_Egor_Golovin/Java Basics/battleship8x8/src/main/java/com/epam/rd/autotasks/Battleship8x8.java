package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        int aim = (int)shot.charAt(0) - 65 + (8 * (Character.getNumericValue(shot.charAt(1)) - 1));
        String ships = toBinaryString(this.ships);
        String shots = toBinaryString(this.shots);

        shots = replaceChar(shots, '1', aim);
        this.shots = Long.parseUnsignedLong(shots,2);
        return ships.charAt(aim) == '1';
    }

    public String state() {
        StringBuilder output = new StringBuilder();
        String ships = toBinaryString(this.ships);
        String shots = toBinaryString(this.shots);

        int i = 0;
        while (i < shots.length()) {
            for (int j = 0; j < 8; i++, j++) {
                switch (ships.charAt(i)) {
                    case '0':
                        switch (shots.charAt(i)) {
                            case '0':
                                output.append('.');
                                break;
                            case '1':
                                output.append('×');
                                break;
                        }
                        break;
                    case '1':
                        switch (shots.charAt(i)) {
                            case '0':
                                output.append('☐');
                                break;
                            case '1':
                                output.append('☒');
                                break;
                        }
                        break;
                }
            } output.append("\n");
        }
        return output.toString();
    }

    public String replaceChar(String str, char ch, int index) {
        return str.substring(0, index) + ch + str.substring(index + 1);
    }

    public String toBinaryString(long lng) {
        return String.format("%64s", Long.toBinaryString(lng)).replace(' ', '0');
    }
}
