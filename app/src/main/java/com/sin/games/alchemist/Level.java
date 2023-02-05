package com.sin.games.alchemist;

public class Level{

    private Field.FieldContent[][] fields;
    private String solution;

    public final void setFields(String strDescription){

        Auxiliary aux=Auxiliary.getInstance();

        fields = new Field.FieldContent[aux.ROW_AMOUNT][aux.COLUMN_AMOUNT];

        int pos=0;
        for(int row=0; row<aux.ROW_AMOUNT; row++){
            for(int column=0; column<aux.COLUMN_AMOUNT; column++){
                switch(strDescription.charAt(pos))
                {
                    case 'N':
                        fields[row][column]=Field.FieldContent.NONE;
                        break;
                    case 'G':
                        fields[row][column]=Field.FieldContent.GOLD;
                        break;
                    case 'P':
                        fields[row][column]=Field.FieldContent.PLUMBUM;
                        break;
                }
                pos++;
            }
        }
    }

    public final String getFields(){

        Auxiliary aux=Auxiliary.getInstance();

        String strDescription="";

        for(int row=0; row<aux.ROW_AMOUNT; row++){
            for(int column=0; column<aux.COLUMN_AMOUNT; column++){
                switch( fields[row][column] )
                {
                    case NONE:
                        strDescription += 'N';
                        break;
                    case GOLD:
                        strDescription += 'G';
                        break;
                    case PLUMBUM:
                        strDescription += 'P';
                        break;
                }
            }
        }

        return strDescription;
    }

    public final Field.FieldContent getContent(int row, int column){

        Auxiliary aux=Auxiliary.getInstance();

        if ( row >= 0 && row < aux.ROW_AMOUNT && column >= 0 && column < aux.COLUMN_AMOUNT){
            return fields[row][column];
        }

        return Field.FieldContent.NONE;
    }

    public final void setContent(Field.FieldContent content, int row, int column){

        Auxiliary aux=Auxiliary.getInstance();

        if ( row >= 0 && row < aux.ROW_AMOUNT && column >= 0 && column < aux.COLUMN_AMOUNT){
            fields[row][column] = content;
        }
    }


}
