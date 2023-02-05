package com.sin.games.alchemist;

public class LevelsManager {

    public static final int DIFFICULT_EASY = 0;
    public static final int DIFFICULT_MEDIUM = 1;
    public static final int DIFFICULT_HARD = 2;

    public static final int DIFFICULT_AMOUNT = 3;

    public static final int LEVELS_AMOUNT = 20;

    private static final String[] easyLevelsDescription = {
            // 1 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNGPNNNNNNNNPGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 2 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPPGNNNNNNNGPPNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 3 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPPNNNNNNNNGGNNNNNNNNPPNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 4 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPGPNNNNNNNGPPNNNNNNNPPGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 5 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNGPNNNNNNNPPGNNNNNNNGPNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 6 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPGNNNNNNNNNPNNNNNNNNNGPNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 7 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPGGNNNNNNNNGPGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 8 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPNNNNNNNPPGNNNNNNNNGPPNNNNNNNPNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 9 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPNNGNNNNNNGPPPNNNNNNGGPGNNNNNNPNNGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 10 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPPGPNNNNNNPPPGNNNNNNGGPPNNNNNNGGPPNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 11 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPGNNNNNNNPPGPNNNNNNGPPGNNNNNNNGGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 12 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPPPGNNNNNNNNGPNNNNNNNNPPNNNNNNGGGPNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 13 level
            "NNNNNNNNNNNNNNNNNNNNNNGGPNNNNNNNGGPNNNNNNNPPPPNNNNNNNNPGPPNNNNNNNPPGNNNNNNNPGPNNNNNNNNNNNNNNNNNNNNNN",
            // 14 level
            "NNNNNNNNNNNNNNNNNNNNNNPGGGNNNNNNGNNGNNNNNNPGGGNNNNNNGPGGGPNNNNNNGNNPNNNNNNPPPPNNNNNNNNNNNNNNNNNNNNNN",
            // 15 level
            "NNNNNNNNNNNNNNNNNNNNNNGPNNPPNNNNPGPPPPNNNNNPNNPNNNNNNPNNPNNNNNGPGGGGNNNNGPNNPPNNNNNNNNNNNNNNNNNNNNNN",
            // 16 level
            "NNNNNNNNNNNNNNNNNNNNNNPPPPPGNNNNGPNNGPNNNNGNNNNPNNNNGNPPNPNNNNGGPGGPNNNNGPNNGPNNNNNNNNNNNNNNNNNNNNNN",
            // 17 level
            "NNNNNNNNNNNNNNNNNNNNNNNNPGNNNNNNPGPPPPNNNNGPNNGGNNNNPPNNGGNNNNPGGPPPNNNNNNPGNNNNNNNNNNNNNNNNNNNNNNNN",
            // 18 level
            "NNNNNNNNNNNNNNNNNNNNNNPPNNGPNNNNNPNNGNNNNNNPGGGNNNNNNGPPGNNNNNNPNNGNNNNNPPNNPPNNNNNNNNNNNNNNNNNNNNNN",
            // 19 level
            "NNNNNNNNNNNNNNNNNNNNNNPPPGPGNNNNGNPGNPNNNNGGNNGPNNNNGGNNGPNNNNGNGPNPNNNNPPPPPPNNNNNNNNNNNNNNNNNNNNNN",
            // 20 level
            "NNNNNNNNNNNNNNNNNNNNNNPGPGGGNNNNPPPGGPNNNNGPGPPGNNNNPGPPGPNNNNPGPGGGNNNNPGPGPPNNNNNNNNNNNNNNNNNNNNNN"
    };
    private static final String[] easyLevelsSolution= {
            // 1 level
            "4554",
            // 2 level
            "5644",
            // 3 level
            "4445",
            // 4 level
            "3445",
            // 5 level
            "3544",
            // 6 level
            "445533",
            // 7 level
            "554554",
            // 8 level
            "43554443",
            // 9 level
            "33563644",
            // 10 level
            "45563656",
            // 11 level
            "65643444",
            // 12 level
            "33646356",
            // 13 level
            "6677434443",
            // 14 level
            "7743422422",
            // 15 level
            "6743366626",
            // 16 level
            "4254237257",
            // 17 level
            "753465757453",
            // 18 level
            "265673772363",
            // 19 level
            "25773553757353",
            // 20 level
            "552267332243764327"
    };

    private static final String[] mediumLevelsDescription = {
            // 1 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPGGGNNNNNNGPPGNNNNNNPPGPNNNNNNGPGPNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 2 level
            "NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNPGNNNNNNNGGPGNNNNNNGPPPNNNNNNNPGNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN",
            // 3 level
            "NNNNNNNNNNNNNNNNNNNNNNPPGGPPNNNNGPPPGGNNNNNNGPNNNNNNNNPPNNNNNNNNPGNNNNNNNNPPNNNNNNNNNNNNNNNNNNNNNNNN",
            // 4 level
            "NNNNNNNNNNNNNNNNNNNNNNGPNNGGNNNNPGPPGPNNNNNPNNGNNNNNNPNNGNNNNNPPPPPPNNNNGPNNGGNNNNNNNNNNNNNNNNNNNNNN",
            // 5 level
            "NNNNNNNNNNNNNGPNNNNNNNNPPNNNNNNNNGPGPGGNNNNPGGGPPNNGGGPGPNNNNGGGPPGNNNNNNNNGPNNNNNNNNGPNNNNNNNNNNNNN",
            // 6 level
            "NNNNNNNNNNNPPNGGNPGNNGPPPPPPPNNNGNGGNPNNNGGGNNGPGNNPGPNNGPGNNNGNPGNPNNNPPPPPPGGNNGGNPGNGPNNNNNNNNNNN",
            // 7 level
            "NNNNNNNNNNNNNNGPNNNNNNNPGPPNNNNNGGPGGPNNNGGPGPGPGNNGPPGPPPGNNNPPGPPPNNNNNGGGPNNNNNNNGPNNNNNNNNNNNNNN",
            // 8 level
            "NNNNNNNNNNNNNNPPNNNNNNNGPGGNNNNNPNNNGPNNNPPNGPPGPNNPGPPGNPPNNNPGNNNPNNNNNGPGGNNNNNNNPPNNNNNNNNNNNNNN",
            // 9 level
            "NNNNNNNNNNNNPPNNPGNNNNPGNNGGNNNNNGNNPNNNNPPPGPGPPNNGGPPPGPGNNNNGNNPNNNNNNGNNPNNNNNNGGGPNNNNNNNNNNNNN",
            // 10 level
            "NNNNNNNNNNNPGPGGPGGNNPNPNNPNGNNPPPPPGPPNNPNPNNPNGNNPNPNNPNGNNGGPGGPGGNNPNPNNPNGNNGGPGGGGGNNNNNNNNNNN",
            // 11 level
            "NNNNNNNNNNNNPPNNPGNNNGNGNNPNGNNGGGGGPGGNNNNNGGNNNNNNNNGGNNNNNGGPGGGGGNNPNPNNPNGNNNGPNNPGNNNNNNNNNNNN",
            // 12 level
            "NNNNNNNNNNNNNNNNNNNNNNNNGGPPNNNNNNGPGGNNNNNNPPPGNNNGGPPGPGNNNPPPGNNNNNNGGPPNNNNNNPPPGNNNNNNNNNNNNNNN",
            // 13 level
            "NNNNNNNNNNNPPPNNNNNNNGPGPNNNNNNPGPPPNNNNNNPPPGGNNNNNNGGPGGNNNNNNPGPPGNNNNNNGGGGNNNNNNNPGPNNNNNNNNNNN",
            // 14 level
            "NNNNNNNNNNNNNGPPPNNNNNPGNNGGNNNPGPPPNGGNNPNPNNGNGNNPNPNNGNGNNPGNPPPPPNNNPGNNGPNNNNNGPPPNNNNNNNNNNNNN",
            // 15 level
            "NNNNNNNNNNNGGNNNNPPNNGGGPPGGPNNNNNPPNNNNNNPPGGGPNNNNPGPGPGNNNNNPPGPNNNNPNNPPNNPNNPPPGGPPPNNNNNNNNNNN",
            // 16 level
            "NNNNNNNNNNNGPNNNNPGNNPGGNNPPGNNNPPPGGPNNNNNGPPPNNNNNNPPGGNNNNNGGNNGGNNNGPPNNPGGNNGPNNNNGPNNNNNNNNNNN",
            // 17 level
            "NNNNNNNNNNNNNNGGNNNNNNNGGPGNNNNNGGPGPPNNNPGNNNNPPNNGPNNNNGPNNNGGGPGPNNNNNPPGGNNNNNNNGGNNNNNNNNNNNNNN",
            // 18 level
            "NNNNNNNNNNNGGGPPGGGNNGNNGPNNPNNGNNPGNNPNNGPGNNPPGNNPGGNNGPPNNGNNPGNNPNNGNNPGNNPNNGGGGGGGPNNNNNNNNNNN",
            // 19 level
            "NNNNNNNNNNNPGGGPGGPNNGNNGPNNGNNGNNPGNNGNNPGPPPPPPNNGGGPPGGGNNGNNPPNNGNNGNNGPNNGNNGPPPGPPPNNNNNNNNNNN",
            // 20 level
            "NNNNNNNNNNNGPPGPPPGNNPGGPGGPPNNPPGPPGGGNNGPPPGPPGNNGPPPPGPGNNGPPGPPPGNNPGPPGGGPNNGPPGGPPPNNNNNNNNNNN"
    };
    private static final String[] mediumLevelsSolution= {
            // 1 level
            "65665436",
            // 2 level
            "54435653",
            // 3 level
            "642345",
            // 4 level
            "463663",
            // 5 level
            "66452465",
            // 6 level
            "438827744111",
            // 7 level
            "4275463773",
            // 8 level
            "3245575414324284",
            // 9 level
            "764126484227165412",
            // 10 level
            "536132813323866731",
            // 11 level
            "714466447326716112",
            // 12 level
            "733452565146545756",
            // 13 level
            "4634125343778676",
            // 14 level
            "1573223583673331",
            // 15 level
            "8774886521184721537454816356",
            // 16 level
            "6282662821788212667644261763",
            // 17 level
            "73525137257358666532237535",
            // 18 level
            "2534438641184352846116514147",
            // 19 level
            "8168616545358387341831115452",
            // 20 level
            "44455154513256358873853827"
    };

    private static final String[] hardLevelsDescription = {
            // 1 level
            "NNNNGGNNNNNNNNPPNNNNNNPPGGPPNNNNGNNNNGNNPPPNPPNGPGPGGNPGNPPPNNGNNNNGNNNNPPPPPPNNNNNNGPNNNNNNNNGPNNNN",
            // 2 level
            "GGPGGGGGGGNNPNNNNNNGGPGPPPPPNGPNNNNNNGNGPNPGGGNGGGPNPNGGNGNGPGPNNNNGNGPNGPPPPPNGPNNNNNGNNGPGGGGGGGGG",
            // 3 level
            "NNNNNNNNNNPPPGPPGPPPNNGPNNPGNNNNPPNNPGNNNPPPNNPPGNGGNGPGGNPPPPNNPPNNPPPPNNGPNNPPPPGGPPGGGGNNNNNNNNNN",
            // 4 level
            "NNNNNNNNNNNGPNNNNPGNPPGPNNGGPPGPGPPPPGPPNNPGNNPGNNNNPPNNGPNNNNPGGGGPNNGGPGNNGPPGGGPNNNNGPPNNNNNNNNNN",
            // 5 level
            "NNNNNNNNNNNPGGPGGGGNNPNNPPNNPNNPNNPGNNPNNGPPGGPPGNNPGPPPGGPNNPNNPPNNPNNPNNGPNNPNNGPPGPPPGNNNNNNNNNNN",
            // 6 level
            "GGPGGGGPGPGNPNGGNPNPPPGPPPPGPGGNPNGGNPNPGGPGNNPPGPGGPGNNPGPGGNPNPPNPNPPPPPPGPGPGGNPNGPNPNPGGPGGPGPGP",
            // 7 level
            "PPGPPPPPGPGGPPNNPGGPPPPNNNNGPGPPNNGGNNGGPNNGGGGNNGPNNGGGGNNGPGNNGGNNPGPGGNNNNGPGPGGGNNGGGGPGGGGGPGPG",
            // 8 level
            "NNNNGGNNNNNNNPGGGNNNNNGPNNGGNNNGPPNNGGPNPGGPPPGGGGPGPPPGPPGGGNNNPGGNNGGNNNPGGNNGGNNNPPPNNGGPPPPPPNNG",
            // 9 level
            "GPNNPGNNGGPPPPPPPPGPNPNNNNNNGNNPNPGPPNGNPGNGGPPNGGGPNPGGPNGGNPNGGGGNGNNPNNNNNNGNGPGGGGGGGPGPNNPPNNPG",
            // 10 level
            "GPNNNNNNPGGPPNNNNPPGNPPPNNGGPNNNGGGGPGNNNNNGNNPNNNNNNGNNPNNNNNPGPPGPNNNGPPNNPPPNPPPNNNNGGGGGNNNNNNGG",
            // 11 level
            "GGGGNNPPGGGPPNNNNPPPPPNNNNNNPGGGNNGPNNGGGGNNPPNNPPGGNNNNNNPPPGNNNNNNPGPGNNGGNNPPPGNNPPNNPPPPPPGGPPGG",
            // 12 level
            "GPPPPPPPPGGGNNPPGGGPPGNNPGPPPGGGNNPGGGGGGPNNPGPPPGGGNNPGGGPPGGNNPPNNGPPGNNNNNNGPGGNNNNNNGGGGGGGGGGGP",
            // 13 level
            "PGPPPPPPGPGPNNNNNNPGGPNNNNNNPGGPNNPGNNPPGPNNPPGGGGGGNNGGPGPGGPNNGGNNPPGGNNNNNNPGPPNNNNNNGGPGPPPPPPGG",
            // 14 level
            "GGGNNNNGGPPGPNNNNPGGGPPNNNNPGGGGGGGGPGPGPGPGPPPPPGGGPPPGPPGGGPGGPGGGPPGGGNNNNPGGPGPNNNNPGGGGGNNNNGGP",
            // 15 level
            "GGPPPPPPGGGGNNNNNNPPPGNNNNNNPPPPNGGGGGPPGGNNNNNGPPPGNNNNNPPGGGNPPPPPGGPGNNNNNNGPPGNNNNNNPPGPPPPPPPGG",
            // 16 level
            "PNNNNNNNNPPGPNNNNGGPGPPGNNGPGGPGGGPGPGPPGGGGPPPGPGPGPNGPNPGGGPPNNNNPPPPGPNNNNPPPPGPNNNNGGPGPPNNNNPPP",
            // 17 level
            "PPPPNNPPGPPPPGNNGGPPPPPPGGGGPGGGGGPPPGPGPPPPNNGPGGGGGPNNPGGPGGGPNNGPGGPGPGNNPPGPGPGGNNPPGPPPPPNNGPGG",
            // 18 level
            "PGNNNNNNPPGGNNNNNNPGGPNNGPGPPPGPNNPGGGGGPGNNNNNNPGGPNNNNNNGGPGGPGPNNPPPGGPGGNNGPGGNNNNNNGGGGNNNNNNGP",
            // 19 level
            "PGPPGPPGGGPPPPPGGPPPPGPPGGGGGGNNNPPGPNNNNNNGPPPNNNNNNGGGGNNNNNNPPGPNNNNNNPGPGNNNNNNPPGPNNNNNNPGPGNNN",
            // 20 level
            "NNPGNNPGNNNPPGPGPPGNNPGGGGGGPNNGGPPGGPPNNNGGGGPGNNNNGPPGPGNNNNNPGGGNNNNNNNGPNNNNNNNNGPNNNNNNGGPGGGNN"
    };
    private static final String[] hardLevelsSolution= {
            // 1 level
            "243715443775584004",
            // 2 level
            "061273062670060052",
            // 3 level
            "542375468850125189",
            // 4 level
            "356488642046264752",
            // 5 level
            "618543181561753471",
            // 6 level
            "6023898772656056",
            // 7 level
            "183988190106861200",
            // 8 level
            "27502694044270454786049036235685409327",
            // 9 level
            "40993686381868845366313498851151821445",
            // 10 level
            "64719128376310239180125676650135912256",
            // 11 level
            "71759639311161312874201021110738816845",
            // 12 level
            "55254044712125393500995805008800042499",
            // 13 level
            "81496568474456573899505870597089550570",
            // 14 level
            "68220164480771500998473931914755683643",
            // 15 level
            "974111586361017930",
            // 16 level
            "4628092267416154365897366078684734923233823982399890389077",
            // 17 level
            "1186896263380613027639531713733881790209587116281727126210",
            // 18 level
            "7370410072807408722462361909346240987190107269016878497363",
            // 19 level
            "2196452116931333531096102510036393281283555324035324180608",
            // 20 level
            "6665954656574403245346132115380317470217423833424694271417"
    };

    public static final String getLevelDescription( int difficult, int level ){
        switch( difficult ) {
            case DIFFICULT_HARD:
                return hardLevelsDescription[level];
            case DIFFICULT_MEDIUM:
                return mediumLevelsDescription[level];
            case DIFFICULT_EASY:
            default:
                return easyLevelsDescription[level];
        }
    }

    public static final String getLevelSolution( int difficult, int level ){
        switch( difficult ) {
            case DIFFICULT_HARD:
                return hardLevelsSolution[level];
            case DIFFICULT_MEDIUM:
                return mediumLevelsSolution[level];
            case DIFFICULT_EASY:
            default:
                return easyLevelsSolution[level];
        }
    }

}