package com.sin.games.alchemist;

public final class Auxiliary {

    public static final int ROW_AMOUNT = 10;
    public static final int COLUMN_AMOUNT = 10;
    public static final int ALL_AMOUNT = ROW_AMOUNT * COLUMN_AMOUNT;

    public final class Position{
        public int row;
        public int column;

        Position(int row, int column){
            this.row = row;
            this.column = column;
        }
    }

    private static final int[] idList = {
            // 1 - row
        R.id.imgField_00_00,
        R.id.imgField_00_01,
        R.id.imgField_00_02,
        R.id.imgField_00_03,
        R.id.imgField_00_04,
        R.id.imgField_00_05,
        R.id.imgField_00_06,
        R.id.imgField_00_07,
        R.id.imgField_00_08,
        R.id.imgField_00_09,

        // 2 - row
        R.id.imgField_01_00,
        R.id.imgField_01_01,
        R.id.imgField_01_02,
        R.id.imgField_01_03,
        R.id.imgField_01_04,
        R.id.imgField_01_05,
        R.id.imgField_01_06,
        R.id.imgField_01_07,
        R.id.imgField_01_08,
        R.id.imgField_01_09,

        // 3 - row
        R.id.imgField_02_00,
        R.id.imgField_02_01,
        R.id.imgField_02_02,
        R.id.imgField_02_03,
        R.id.imgField_02_04,
        R.id.imgField_02_05,
        R.id.imgField_02_06,
        R.id.imgField_02_07,
        R.id.imgField_02_08,
        R.id.imgField_02_09,

        // 4 - row
        R.id.imgField_03_00,
        R.id.imgField_03_01,
        R.id.imgField_03_02,
        R.id.imgField_03_03,
        R.id.imgField_03_04,
        R.id.imgField_03_05,
        R.id.imgField_03_06,
        R.id.imgField_03_07,
        R.id.imgField_03_08,
        R.id.imgField_03_09,

        // 5 - row
        R.id.imgField_04_00,
        R.id.imgField_04_01,
        R.id.imgField_04_02,
        R.id.imgField_04_03,
        R.id.imgField_04_04,
        R.id.imgField_04_05,
        R.id.imgField_04_06,
        R.id.imgField_04_07,
        R.id.imgField_04_08,
        R.id.imgField_04_09,

        // 6 - row
        R.id.imgField_05_00,
        R.id.imgField_05_01,
        R.id.imgField_05_02,
        R.id.imgField_05_03,
        R.id.imgField_05_04,
        R.id.imgField_05_05,
        R.id.imgField_05_06,
        R.id.imgField_05_07,
        R.id.imgField_05_08,
        R.id.imgField_05_09,

        // 7 - row
        R.id.imgField_06_00,
        R.id.imgField_06_01,
        R.id.imgField_06_02,
        R.id.imgField_06_03,
        R.id.imgField_06_04,
        R.id.imgField_06_05,
        R.id.imgField_06_06,
        R.id.imgField_06_07,
        R.id.imgField_06_08,
        R.id.imgField_06_09,

        // 8 - row
        R.id.imgField_07_00,
        R.id.imgField_07_01,
        R.id.imgField_07_02,
        R.id.imgField_07_03,
        R.id.imgField_07_04,
        R.id.imgField_07_05,
        R.id.imgField_07_06,
        R.id.imgField_07_07,
        R.id.imgField_07_08,
        R.id.imgField_07_09,

        // 9 - row
        R.id.imgField_08_00,
        R.id.imgField_08_01,
        R.id.imgField_08_02,
        R.id.imgField_08_03,
        R.id.imgField_08_04,
        R.id.imgField_08_05,
        R.id.imgField_08_06,
        R.id.imgField_08_07,
        R.id.imgField_08_08,
        R.id.imgField_08_09,

        // 10 - row
        R.id.imgField_09_00,
        R.id.imgField_09_01,
        R.id.imgField_09_02,
        R.id.imgField_09_03,
        R.id.imgField_09_04,
        R.id.imgField_09_05,
        R.id.imgField_09_06,
        R.id.imgField_09_07,
        R.id.imgField_09_08,
        R.id.imgField_09_09
    };

    public final Position positionById( int id ){
        Position pos = new Position(0, 0);

        for(int row=0;row<ROW_AMOUNT; row++){
            for(int column=0; column<COLUMN_AMOUNT; column++){
                if ( idList[row * COLUMN_AMOUNT + column] == id ){
                    pos.row = row;
                    pos.column = column;
                    return pos;
                }
            }
        }

        return pos;
    }

    public final int idByPosition( Position pos ){
        return idList[pos.row * COLUMN_AMOUNT + pos.column];
    }

    public final int idByPosition( int row, int column ){
        return idList[row * COLUMN_AMOUNT + column];
    }

    private static volatile Auxiliary instance = null;

    private Auxiliary(){}

    public static Auxiliary getInstance(){
        if ( instance == null ){
            synchronized ( Auxiliary.class ){
                if ( instance == null ){
                    instance = new Auxiliary();
                }
            }
        }
        return instance;
    }
}
