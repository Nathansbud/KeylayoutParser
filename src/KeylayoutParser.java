import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;


public class KeylayoutParser {

    enum Key {
        A("A"),
        B("B"),
        C("C"),
        D("D"),
        E("E"),
        F("F"),
        G("G"),
        H("H"),
        I("I"),
        J("J"),
        K("K"),
        L("L"),
        M("M"),
        N("N"),
        O("O"),
        P("P"),
        Q("Q"),
        R("R"),
        S("S"),
        T("T"),
        U("U"),
        V("V"),
        W("W"),
        X("X"),
        Y("Y"),
        Z("Z"),
        ZERO("0"),
        ONE("1"),
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        EQUALS("="),
        HYPHEN("-"),
        BACKQUOTE("`"),
        SQUARE_BRACKET_LEFT("["),
        SQUARE_BRACKET_RIGHT("]"),
        BACKSLASH("\\"),
        SEMICOLON(";"),
        APOSTROPHE("'"),
        COMMA(","),
        PERIOD("."),
        SLASH("/"),
        ENTER("Enter"),
        RETURN("Return"),
        LEFT_ARROW("Left Arrow Key"),
        RIGHT_ARROW("Right Arrow Key"),
        UP_ARROW("Up Arrow Key"),
        DOWN_ARROW("Down Arrow Key"),
        TAB("Tab"),
        SPACE("Space"),
        TILDE("~"),
        DELETE("Delete"),
        ESCAPE("Esc"),

        F1("F1"),
        F2("F2"),
        F3("F3"),
        F4("F4"),
        F5("F5"),
        F6("F6"),
        F7("F7"),
        F8("F8"),
        F9("F9"),
        F10("F10"),
        F11("F11"),
        F12("F12"),
        F13("F13"),
        F14("F14"),
        F15("F15"),
        F16("F16"),
        F17("F17"),
        F18("F18"),
        F19("F19"),
        F20("F19"),
        COMMAND("Command"),
        LEFT_SHIFT("LShift"),
        RIGHT_SHIFT("RShift"),
        LEFT_OPTION("LOption"),
        RIGHT_OPTION("ROption"),
        LEFT_CONTROL("LCtrl"),
        RIGHT_CONTROL("RCtrl"),
        CAPS_LOCK("Caps Locl"),
        FUNCTION("Fn"),
        NUMPAD_PERIOD("Numpad ."),
        NUMPAD_ZERO("Numpad 0"),
        NUMPAD_ONE("Numpad 1"),
        NUMPAD_TWO("Numpad 2"),
        NUMPAD_THREE("Numpad 3"),
        NUMPAD_FOUR("Numpad 4"),
        NUMPAD_FIVE("Numpad 5"),
        NUMPAD_SIX("Numpad 6"),
        NUMPAD_SEVEN("Numpad 7"),
        NUMPAD_EIGHT("Numpad 8"),
        NUMPAD_NINE("Numpad 9"),
        NUMPAD_ASTERISK("Numpad *"),
        NUMPAD_PLUS("Numpad +"),
        NUMPAD_CLEAR("Numpad Clear"),
        NUMPAD_SLASH("Numpad /"),
        NUMPAD_HYPHEN("Numpad -"),
        NUMPAD_EQUALS("Numpad ="),

        DEL("Del"),
        END("End"),
        HOME("Home"),
        PAGE_UP("PGUP"),
        PAGE_DOWN("PGDN"),

        UNMAPPED("Unmapped");

        Key(String _display) {
            display = _display;
        }
        private String display;
        public String getDisplay() {
            return display;
        }
    }
    enum Modifier {
        NONE("Normal"), //0
        SHIFT("Shift"), //1
        CAPS("Caps"), //2
        ALT("Alt"), //3, I call it alt, it's option as well
        ALT_SHIFT("Alt + Shift"), //4,
        ALT_CAPS("Alt + Caps"), //5
        ALT_COMMAND("Alt + Command"), //6
        SHIFT_CTRL("Shift + Ctrl"); //7


        Modifier(String _display) {
            display = _display;
        }
        private String display;
        public String getDisplay() {
            return display;
        }
    }

    private static HashMap<String, Key> keyMap = new HashMap<String, Key>();
    private static HashMap<String, Modifier> modifierMap = new HashMap<String, Modifier>();

    public static void setupKeyMap() {
        //Key Mapping
        keyMap.put("0", Key.A);
        keyMap.put("1", Key.S);
        keyMap.put("2", Key.D);
        keyMap.put("3", Key.F);
        keyMap.put("4", Key.H);
        keyMap.put("5", Key.G);
        keyMap.put("6", Key.Z);
        keyMap.put("7", Key.X);
        keyMap.put("8", Key.C);
        keyMap.put("9", Key.V);
        keyMap.put("10", Key.UNMAPPED);
        keyMap.put("11", Key.B);
        keyMap.put("12", Key.Q);
        keyMap.put("13", Key.W);
        keyMap.put("14", Key.E);
        keyMap.put("15", Key.R);
        keyMap.put("16", Key.Y);
        keyMap.put("17", Key.T);
        keyMap.put("18", Key.ONE);
        keyMap.put("19", Key.TWO);
        keyMap.put("20", Key.THREE);
        keyMap.put("21", Key.FOUR);
        keyMap.put("22", Key.SIX);
        keyMap.put("23", Key.FIVE);
        keyMap.put("24", Key.EQUALS);
        keyMap.put("25", Key.NINE);
        keyMap.put("26", Key.SEVEN);
        keyMap.put("27", Key.HYPHEN);
        keyMap.put("28", Key.EIGHT);
        keyMap.put("29", Key.ZERO);
        keyMap.put("30", Key.SQUARE_BRACKET_RIGHT);
        keyMap.put("31", Key.O);
        keyMap.put("32", Key.U);
        keyMap.put("33", Key.SQUARE_BRACKET_LEFT);
        keyMap.put("34", Key.I);
        keyMap.put("35", Key.P);
        keyMap.put("36", Key.RETURN);
        keyMap.put("37", Key.L);
        keyMap.put("38", Key.J);
        keyMap.put("39", Key.APOSTROPHE);
        keyMap.put("40", Key.K);
        keyMap.put("41", Key.SEMICOLON);
        keyMap.put("42", Key.BACKSLASH);
        keyMap.put("43", Key.COMMA);
        keyMap.put("44", Key.SLASH);
        keyMap.put("45", Key.N);
        keyMap.put("46", Key.M);
        keyMap.put("47", Key.PERIOD);
        keyMap.put("48", Key.TAB);
        keyMap.put("49", Key.SPACE);
        keyMap.put("50", Key.TILDE);
        keyMap.put("51", Key.DELETE);
        keyMap.put("52", Key.UNMAPPED);
        keyMap.put("53", Key.ESCAPE);
        keyMap.put("54", Key.UNMAPPED);
        keyMap.put("55", Key.COMMAND);
        keyMap.put("56", Key.LEFT_SHIFT);
        keyMap.put("57", Key.CAPS_LOCK);
        keyMap.put("58", Key.LEFT_OPTION);
        keyMap.put("59", Key.LEFT_CONTROL);
        keyMap.put("60", Key.RIGHT_SHIFT);
        keyMap.put("61", Key.RIGHT_OPTION);
        keyMap.put("62", Key.RIGHT_CONTROL);
        keyMap.put("63", Key.FUNCTION);
        keyMap.put("64", Key.F17);
        keyMap.put("65", Key.NUMPAD_PERIOD);
        keyMap.put("66", Key.UNMAPPED);
        keyMap.put("67", Key.NUMPAD_ASTERISK);
        keyMap.put("68", Key.UNMAPPED);
        keyMap.put("69", Key.NUMPAD_PLUS);
        keyMap.put("70", Key.UNMAPPED);
        keyMap.put("71", Key.NUMPAD_CLEAR);
        keyMap.put("72", Key.UNMAPPED);
        keyMap.put("73", Key.UNMAPPED);
        keyMap.put("74", Key.UNMAPPED);
        keyMap.put("75", Key.NUMPAD_SLASH);
        keyMap.put("76", Key.ENTER);
        keyMap.put("77", Key.UNMAPPED);
        keyMap.put("78", Key.NUMPAD_HYPHEN);
        keyMap.put("79", Key.F18);
        keyMap.put("80", Key.F19);
        keyMap.put("81", Key.NUMPAD_EQUALS);
        keyMap.put("82", Key.NUMPAD_ZERO);
        keyMap.put("83", Key.NUMPAD_ONE);
        keyMap.put("84", Key.NUMPAD_TWO);
        keyMap.put("85", Key.NUMPAD_TWO);
        keyMap.put("86", Key.NUMPAD_FOUR);
        keyMap.put("87", Key.NUMPAD_FIVE);
        keyMap.put("88", Key.NUMPAD_SIX);
        keyMap.put("89", Key.NUMPAD_SEVEN);
        keyMap.put("90", Key.F20);
        keyMap.put("91", Key.NUMPAD_EIGHT);
        keyMap.put("92", Key.NUMPAD_NINE);
        keyMap.put("93", Key.UNMAPPED);
        keyMap.put("94", Key.UNMAPPED);
        keyMap.put("95", Key.UNMAPPED);
        keyMap.put("96", Key.F5);
        keyMap.put("97", Key.F6);
        keyMap.put("98", Key.F7);
        keyMap.put("99", Key.F3);
        keyMap.put("100", Key.F8);
        keyMap.put("101", Key.F9);
        keyMap.put("102", Key.UNMAPPED);
        keyMap.put("103", Key.F11);
        keyMap.put("104", Key.UNMAPPED);
        keyMap.put("105", Key.F13);
        keyMap.put("106", Key.F16);
        keyMap.put("107", Key.F14);
        keyMap.put("108", Key.UNMAPPED);
        keyMap.put("109", Key.F10);
        keyMap.put("110", Key.UNMAPPED);
        keyMap.put("111", Key.F12);
        keyMap.put("112", Key.UNMAPPED);
        keyMap.put("113", Key.F15);
        keyMap.put("114", Key.UNMAPPED);
        keyMap.put("115", Key.HOME);
        keyMap.put("116", Key.PAGE_UP);
        keyMap.put("117", Key.DEL);
        keyMap.put("118", Key.F4);
        keyMap.put("119", Key.END);
        keyMap.put("120", Key.F2);
        keyMap.put("121", Key.PAGE_DOWN);
        keyMap.put("122", Key.F1);
        keyMap.put("123", Key.LEFT_ARROW);
        keyMap.put("124", Key.RIGHT_ARROW);
        keyMap.put("125", Key.DOWN_ARROW);
        keyMap.put("126", Key.UP_ARROW);
        keyMap.put("127", Key.UNMAPPED);
        keyMap.put("128", Key.UNMAPPED);
        keyMap.put("129", Key.UNMAPPED);
        keyMap.put("130", Key.UNMAPPED);
        keyMap.put("131", Key.F4);
        keyMap.put("132", Key.UNMAPPED);
        keyMap.put("133", Key.UNMAPPED);
        keyMap.put("134", Key.UNMAPPED);
        keyMap.put("135", Key.UNMAPPED);
        keyMap.put("136", Key.UNMAPPED);
        keyMap.put("137", Key.UNMAPPED);
        keyMap.put("138", Key.UNMAPPED);
        keyMap.put("139", Key.UNMAPPED);
        keyMap.put("140", Key.UNMAPPED);
        keyMap.put("141", Key.UNMAPPED);
        keyMap.put("142", Key.UNMAPPED);
        keyMap.put("143", Key.UNMAPPED);
        keyMap.put("144", Key.UNMAPPED);
        keyMap.put("145", Key.UNMAPPED);
        keyMap.put("146", Key.UNMAPPED);
        keyMap.put("147", Key.UNMAPPED);
        keyMap.put("148", Key.UNMAPPED);
        keyMap.put("149", Key.UNMAPPED);
        keyMap.put("150", Key.UNMAPPED);
        keyMap.put("151", Key.UNMAPPED);
        keyMap.put("152", Key.UNMAPPED);
        keyMap.put("153", Key.UNMAPPED);
        keyMap.put("154", Key.UNMAPPED);
        keyMap.put("155", Key.UNMAPPED);
        keyMap.put("156", Key.UNMAPPED);
        keyMap.put("157", Key.UNMAPPED);
        keyMap.put("158", Key.UNMAPPED);
        keyMap.put("159", Key.UNMAPPED);
        keyMap.put("160", Key.F3);
        //Modifier Mapping
        modifierMap.put("0", Modifier.NONE);
        modifierMap.put("1", Modifier.SHIFT);
        modifierMap.put("2", Modifier.CAPS);
        modifierMap.put("3", Modifier.ALT);
        modifierMap.put("4", Modifier.ALT_SHIFT);
        modifierMap.put("5", Modifier.ALT_CAPS);
        modifierMap.put("6", Modifier.ALT_COMMAND);
        modifierMap.put("7", Modifier.SHIFT_CTRL);
    }
    private static void readKeylayout(String filepath) {
        File f = new File(filepath);
        try
        {
            FileInputStream fis = new FileInputStream(f);
            Document d = Jsoup.parse(fis, "UTF-8", "", Parser.xmlParser());

            Element keyMapping = d.selectFirst("keyMapSet#16c");
            Elements keySets = keyMapping.select("keyMap");

            for(Element e : keySets) {
                Modifier modifier = modifierMap.get(e.attr("index"));
                System.out.println("--- " + modifier.getDisplay() + " Set ---");

                for (Element k : e.children()) {


                    Key marker = keyMap.get(k.attr("code"));
                    String output;
                    if (k.hasAttr("action")) {
                        Element actionSet = d.select("action[id='" + k.attr("action") + "']").get(0);
                        output = actionSet.child(0).attr("output");
                    } else {
                        output = k.attr("output");
                    }

                    if (marker != Key.UNMAPPED) {
                        switch(output) {
                            case "&#x000A;": output = "Enter"; break;
                            default: break;
                        }
                        System.out.println(((modifier != Modifier.NONE) ? (modifier.getDisplay() + " + ") : ("")) + (marker).getDisplay() + ": " + output);
                    }
                }
            }
        } catch(IOException e) {
            System.out.println(":((");
        }
    }

    public static void main(String[] args) {
        setupKeyMap();
        readKeylayout("/Users/zackamiton/Library/Input Methods/Cute.keylayout");
    }
}
