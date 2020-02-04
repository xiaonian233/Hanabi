package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public class StaffAnalyzer extends Mod
{
    public static String[] modlist;
    private String modname;
    private List<String> offlinemod;
    public List<String> onlinemod;
    private Value<Boolean> showOffline;
    private Value<Boolean> showOnline;
    private int counter;
    private boolean isFinished;
    public static Class38 ui;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llllIlllII;
    
    public StaffAnalyzer() {
        super("StaffAnalyzer", Category.PLAYER);
        this.offlinemod = new ArrayList<String>();
        this.onlinemod = new ArrayList<String>();
        new Value("StaffAnalyzer_ShowOffline", Boolean.TRUE);
        new Value("StaffAnalyzer_ShowOnline", Boolean.TRUE);
        this.isFinished = false;
        final Minecraft mc = StaffAnalyzer.mc;
        new ScaledResolution(StaffAnalyzer.mc);
        StaffAnalyzer.ui = new Class38(mc);
    }
    
    @EventTarget
    private static void onRender$26896c00() {
    }
    
    @EventTarget
    private void onChat(final EventChat eventChat) {
        final int[] b = Class139.b();
        boolean b7;
        boolean contains;
        boolean b6;
        boolean b5;
        boolean b4;
        boolean b3;
        final boolean b2 = b3 = (b4 = (b5 = (b6 = (contains = (b7 = eventChat.message.contains("分钟的聊天"))))));
        if (b == null) {
            if (b2) {
                StaffAnalyzer.mc.field_71439_g.func_71165_d("/chat a");
            }
            final boolean b8;
            b3 = (b8 = (b4 = (b5 = (b6 = (contains = (b7 = eventChat.message.contains("这名玩家不在线！")))))));
        }
        final boolean b9;
        Label_0214: {
            Label_0205: {
                if (b == null) {
                    if (!b2) {
                        b9 = (b6 = (contains = (b7 = eventChat.message.contains("That player is not online!"))));
                        if (b != null) {
                            break Label_0214;
                        }
                        if (!b9) {
                            break Label_0205;
                        }
                    }
                    eventChat.cancelled = true;
                    b4 = (b3 = (b5 = (b6 = (contains = (b7 = this.onlinemod.contains(this.modname))))));
                }
                if (b == null) {
                    if (b3) {
                        Class333.tellPlayer(String.valueOf(new StringBuilder("§b[Hanabi]§c").append(this.modname).append("§a已下线！")));
                        this.onlinemod.remove(this.modname);
                        this.offlinemod.add(this.modname);
                        return;
                    }
                    b4 = (b6 = (contains = (b7 = this.offlinemod.contains(this.modname))));
                }
                if (b != null) {
                    break Label_0214;
                }
                if (!b4) {
                    Class333.tellPlayer(String.valueOf(new StringBuilder("§b[Hanabi]§c").append(this.modname).append("§a不在线！")));
                    this.offlinemod.add(this.modname);
                }
            }
            b6 = (b5 = (contains = (b7 = eventChat.message.contains("You cannot message this player."))));
        }
        EventChat eventChat2 = null;
        Label_0446: {
            final boolean contains2;
            Label_0414: {
                Label_0379: {
                    if (b == null) {
                        if (!b9) {
                            contains2 = eventChat.message.contains("分钟的聊天");
                            if (b != null) {
                                break Label_0414;
                            }
                            if (!contains2) {
                                break Label_0379;
                            }
                        }
                        eventChat.cancelled = true;
                        contains = (b6 = (b7 = this.offlinemod.contains(this.modname)));
                    }
                    if (b == null) {
                        if (b6) {
                            Class333.tellPlayer(String.valueOf(new StringBuilder("§b[Hanabi]§c").append(this.modname).append("§a已上线！")));
                            this.offlinemod.remove(this.modname);
                            this.onlinemod.add(this.modname);
                            return;
                        }
                        contains = this.onlinemod.contains(this.modname);
                    }
                    if (b != null) {
                        break Label_0414;
                    }
                    if (!contains) {
                        Class333.tellPlayer(String.valueOf(new StringBuilder("§b[Hanabi]§c").append(this.modname).append("§a在线！")));
                        this.onlinemod.add(this.modname);
                    }
                }
                eventChat2 = eventChat;
                if (b != null) {
                    break Label_0446;
                }
                eventChat.message.contains(String.valueOf(new StringBuilder("找不到名为 \"").append(this.modname).append("\" 的玩家")));
            }
            if (!contains2) {
                return;
            }
            System.out.println(String.valueOf(new StringBuilder().append(this.modname).append("不存在！")));
            eventChat2 = eventChat;
        }
        eventChat2.cancelled = true;
    }
    
    @EventTarget
    private void onUpdate$3a3d1cb1() {
        final int[] b = Class139.b();
        final int n = StaffAnalyzer.mc.field_71439_g.field_70173_aa % 120;
        StaffAnalyzer staffAnalyzer = null;
        Label_0078: {
            if (b == null) {
                if (n != 0) {
                    return;
                }
                staffAnalyzer = this;
                if (b != null) {
                    break Label_0078;
                }
                final int counter = this.counter;
            }
            if (n >= StaffAnalyzer.modlist.length) {
                this.counter = -1;
                staffAnalyzer = this;
                if (b != null) {
                    break Label_0078;
                }
                if (!this.isFinished) {
                    this.isFinished = true;
                }
            }
            ++this.counter;
            staffAnalyzer = this;
        }
        staffAnalyzer.modname = StaffAnalyzer.modlist[this.counter];
        StaffAnalyzer.mc.field_71439_g.func_71165_d(String.valueOf(new StringBuilder("/msg ").append(this.modname)));
    }
    
    static {
        lIllIIIllIII();
        Class169.a(-1399661255171061394L, 5476876233927791866L, MethodHandles.lookup().lookupClass()).a(180608039396918L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(StaffAnalyzer.llllIlllII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(StaffAnalyzer.llllIlllII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(33113495987776L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[31];
        int n2 = 0;
        final String s = "úübÀ\u001e\u0002>\u001aÑ\u0087Ó7½¦§Á\u009d%ðÃRê´\u001d\u0013úÛ©\u0089°\u0097µ `\fBÒ9CAÚÛèa½ÂÂÒ¶Ï\u00adÆ\u009a\u001a\u0011\u007f'÷»#\u0085øöÓq\u0010oÄã_Ó\u000f'¥ñÑ\u0002M\u0015K\u00ad\u0087\u0018TÓ0\u0012\u0096\u0004bXi6R]æµtí~ðÂ|+Ã\u0081Õ /æ$2B¤\u0012>!K\u008cÀÄ\u008eÊ0êC\u0092Ó\u0083¢{\u0085;Ã\u0082\u0000\u001b1Ð=0\u001f\u009a;Õ\t{=\u0084\u00841L\u0093¥\u0011T\b£½Ó\u008d·w\u0004\rÓ6\bè®\u000b\u001dE\u0082_\u009cTÚÓõX.YÿÊCý×Ð\u0018z\u0019V_\u000e¨\t!EîlRyrñe¥)Ìþº*k\u009e\u0018\u008faÏË\u001d\u0000+Cä\u0081G\u008añ\u0018©1¢\u0092³~\u0086Ds\r ©\u0000ú¨Ð\u008ee¦z××®$ïªiÝ+ö\u00ad>\u0097| (\u000e\u0001\u0001:£þ\u0091\u0018\u0011c¶\u001d\u0019q\u0012\\/ÿ\"Ï\u0002ÌÊ;\u0019ÓÒ\u009d_\u001c\u009aë\u0010F¨R\u0087\u0098®~\u0019\u009bE6zY\u000fV³0£û\u0018w\u001aúsÐõ¢|\u0005\u001fmó0ºû\u0015\u000b`©(L`ÛÑØçÚæ<%\u00038\t\u0095cfê9Kà\b\u008b.pê p$\u0011»-ÁP!\u0004¨¡§`MD)*\"7!.ûû9\u0005wè\u0095\u0098'Ø\u0097 j\u0093\u0093Ä\n\bà¸KO\u0003\u0013\u0087&µâ\u0019Ëç¿k7\u0095¬Ü\u008a\u0080ôbì\u0011@8²~*%Â@Ä\u0005y\u009a\u0019¸\u0019´\u001fÁá,ÞhM}1\u008eÙþØ\\Ù1\u0010XÜ\u0090\u009d\u001eM¡è@\u0002\n?'î°Ð¥jæ\u0005ñ\rJ(z ýfdmé\u0011\u001c:Ý\u009d*F%ã£Nn_Oßåq\u0081jK\u0093{áIÅë\u0019\u0010\u001bº\u0013¿\u0081¼«±\u008e\u0016&Ñ¥\u0013)ø \u00198'\u007f\u0097cÁÃüìg\u0097mUÇ?|Eùh?%eºèMê\u008f\u0019\u000bßï\u0018ruV¤ð\t~~¬û\u008c\u0016a2>[\b\u0096ë\\-\u0093åP\u0010ÖSns\u0080%I\u0017ïÙcíDùã\"0QVVÅ\u0010\u009d\u0007\u000e\u001fþ\u009cÏ\u0000Y\b#\u00ad¦¦\u008an\u009b\u0081§%öËF\u001ey\u008b ö¬íº¼A3\u0005ÂÎog` ú\u0005\u0010iâñJø»\u0015\u009c\u007fä¡G¿vëõ\u0018\u008c\u0084nl:\u0019Ò\u008b\u00910¬Í\u0097\u001bÉ[\u007fq¸\u0017¸ ¨W\u0018\u0099¬\u0001\bºí\u0082j@¦\u00195\u0011Ó\"\r-ÛV;;\u0013¸]03l\u0019Væé8Þ\u0013´ë®îÙE\n$ZhÈ1¨Ï/·\u0007´ÏË\rµ><\u0096íaÔ\u0006\u0018æâ\"ôÊ\u001dÌ¤Q\u0018\u000fáSð¦Ád\u009fÊ¶ì\u0093\u001a\u001a\u001c\u009f\"§\u0016*üô¶\u0089\u0010\u0001q\u0097xg®ó\tG·Á»l\b>³\u0018\u0016ChTµt3xë\u009dÞ\u009aÅ¼n5É2\u0000Ù¾g\u009eÇ I\u0090Äü/;\u008dÄÄ`ÖÉ\fc¼\"r{<·\u0016\u0002á÷¯Ë·NrêG\u0096";
        String s2 = "úübÀ\u001e\u0002>\u001aÑ\u0087Ó7½¦§Á\u009d%ðÃRê´\u001d\u0013úÛ©\u0089°\u0097µ `\fBÒ9CAÚÛèa½ÂÂÒ¶Ï\u00adÆ\u009a\u001a\u0011\u007f'÷»#\u0085øöÓq\u0010oÄã_Ó\u000f'¥ñÑ\u0002M\u0015K\u00ad\u0087\u0018TÓ0\u0012\u0096\u0004bXi6R]æµtí~ðÂ|+Ã\u0081Õ /æ$2B¤\u0012>!K\u008cÀÄ\u008eÊ0êC\u0092Ó\u0083¢{\u0085;Ã\u0082\u0000\u001b1Ð=0\u001f\u009a;Õ\t{=\u0084\u00841L\u0093¥\u0011T\b£½Ó\u008d·w\u0004\rÓ6\bè®\u000b\u001dE\u0082_\u009cTÚÓõX.YÿÊCý×Ð\u0018z\u0019V_\u000e¨\t!EîlRyrñe¥)Ìþº*k\u009e\u0018\u008faÏË\u001d\u0000+Cä\u0081G\u008añ\u0018©1¢\u0092³~\u0086Ds\r ©\u0000ú¨Ð\u008ee¦z××®$ïªiÝ+ö\u00ad>\u0097| (\u000e\u0001\u0001:£þ\u0091\u0018\u0011c¶\u001d\u0019q\u0012\\/ÿ\"Ï\u0002ÌÊ;\u0019ÓÒ\u009d_\u001c\u009aë\u0010F¨R\u0087\u0098®~\u0019\u009bE6zY\u000fV³0£û\u0018w\u001aúsÐõ¢|\u0005\u001fmó0ºû\u0015\u000b`©(L`ÛÑØçÚæ<%\u00038\t\u0095cfê9Kà\b\u008b.pê p$\u0011»-ÁP!\u0004¨¡§`MD)*\"7!.ûû9\u0005wè\u0095\u0098'Ø\u0097 j\u0093\u0093Ä\n\bà¸KO\u0003\u0013\u0087&µâ\u0019Ëç¿k7\u0095¬Ü\u008a\u0080ôbì\u0011@8²~*%Â@Ä\u0005y\u009a\u0019¸\u0019´\u001fÁá,ÞhM}1\u008eÙþØ\\Ù1\u0010XÜ\u0090\u009d\u001eM¡è@\u0002\n?'î°Ð¥jæ\u0005ñ\rJ(z ýfdmé\u0011\u001c:Ý\u009d*F%ã£Nn_Oßåq\u0081jK\u0093{áIÅë\u0019\u0010\u001bº\u0013¿\u0081¼«±\u008e\u0016&Ñ¥\u0013)ø \u00198'\u007f\u0097cÁÃüìg\u0097mUÇ?|Eùh?%eºèMê\u008f\u0019\u000bßï\u0018ruV¤ð\t~~¬û\u008c\u0016a2>[\b\u0096ë\\-\u0093åP\u0010ÖSns\u0080%I\u0017ïÙcíDùã\"0QVVÅ\u0010\u009d\u0007\u000e\u001fþ\u009cÏ\u0000Y\b#\u00ad¦¦\u008an\u009b\u0081§%öËF\u001ey\u008b ö¬íº¼A3\u0005ÂÎog` ú\u0005\u0010iâñJø»\u0015\u009c\u007fä¡G¿vëõ\u0018\u008c\u0084nl:\u0019Ò\u008b\u00910¬Í\u0097\u001bÉ[\u007fq¸\u0017¸ ¨W\u0018\u0099¬\u0001\bºí\u0082j@¦\u00195\u0011Ó\"\r-ÛV;;\u0013¸]03l\u0019Væé8Þ\u0013´ë®îÙE\n$ZhÈ1¨Ï/·\u0007´ÏË\rµ><\u0096íaÔ\u0006\u0018æâ\"ôÊ\u001dÌ¤Q\u0018\u000fáSð¦Ád\u009fÊ¶ì\u0093\u001a\u001a\u001c\u009f\"§\u0016*üô¶\u0089\u0010\u0001q\u0097xg®ó\tG·Á»l\b>³\u0018\u0016ChTµt3xë\u009dÞ\u009aÅ¼n5É2\u0000Ù¾g\u009eÇ I\u0090Äü/;\u008dÄÄ`ÖÉ\fc¼\"r{<·\u0016\u0002á÷¯Ë·NrêG\u0096";
        int n3 = s.length();
        int n4 = 32;
        int n5 = -1;
    Label_0147:
        while (true) {
            while (true) {
                ++n5;
                final String s3 = s2;
                final int n6 = n5;
                String s4 = s3.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s4.getBytes(StaffAnalyzer.llllIlllII[3]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                continue Label_0147;
                            }
                            n3 = (s2 = StaffAnalyzer.llllIlllII[2]).length();
                            n4 = 40;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                break;
                            }
                            break Label_0147;
                        }
                    }
                    ++n5;
                    final String s5 = s2;
                    final int n8 = n5;
                    s4 = s5.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        c = c2;
        d = new String[31];
        StaffAnalyzer.modlist = new String[] { "startover_", "小阿狸", "chen_xixi", "tanker_01", "SnowDay", "造化钟神秀", "Owenkill", "chen_duxiu", "绅士龙", "mxu", "chrisan", "囧YJH" };
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static String b(final byte[] array) {
        int n = 0;
        final int length;
        final char[] array2 = new char[length = array.length];
        for (int i = 0; i < length; ++i) {
            final int n2;
            if ((n2 = (0xFF & array[i])) < 192) {
                array2[n++] = (char)n2;
            }
            else if (n2 < 224) {
                array2[n++] = (char)((char)((char)(n2 & 0x1F) << 6) | (char)(array[++i] & 0x3F));
            }
            else if (i < length - 2) {
                array2[n++] = (char)((char)((char)((char)(n2 & 0xF) << 12) | (char)(array[++i] & 0x3F) << 6) | (char)(array[++i] & 0x3F));
            }
        }
        return new String(array2, 0, n);
    }
    
    private static String b(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7F87;
        if (StaffAnalyzer.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = StaffAnalyzer.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(StaffAnalyzer.llllIlllII[4]);
                    array[1] = SecretKeyFactory.getInstance(StaffAnalyzer.llllIlllII[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    StaffAnalyzer.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(StaffAnalyzer.llllIlllII[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            StaffAnalyzer.d[n3] = b(((Cipher)array[0]).doFinal(StaffAnalyzer.c[n3].getBytes(StaffAnalyzer.llllIlllII[7])));
        }
        return StaffAnalyzer.d[n3];
    }
    
    private static void lIllIIIllIII() {
        (llllIlllII = new String[11])[0] = "DES/CBC/PKCS5Padding";
        StaffAnalyzer.llllIlllII[1] = "DES";
        StaffAnalyzer.llllIlllII[2] = "D\u009eD\rx~\u0087°ýG¦_GH\u0081ê\u0085\u0098{)°V\u008b\u001b\u0088}1\u0017éT\u0014TE¢\u0090G;¬\u009aÝ ¾ÎÏ=®\u0010ÞÙL«¬×\u000f®jkp¾$\u0004\u009fm@À§H3CÝAZÓ";
        StaffAnalyzer.llllIlllII[3] = "ISO-8859-1";
        StaffAnalyzer.llllIlllII[4] = "DES/CBC/PKCS5Padding";
        StaffAnalyzer.llllIlllII[5] = "DES";
        StaffAnalyzer.llllIlllII[6] = "你不是自以为是大手可以登峰造极唯我独尊的吗可是我完全没必要你是不是跟我说一句话要经过大脑半天的思考才敢发出来我这速度嗷嗷的快耀武扬威你了解什么情况反抗似的NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u200c\u2008\u200a";
        StaffAnalyzer.llllIlllII[7] = "ISO-8859-1";
        StaffAnalyzer.llllIlllII[8] = "你不是自以为是大手可以登峰造极唯我独尊的吗可是我完全没必要你是不是跟我说一句话要经过大脑半天的思考才敢发出来我这速度嗷嗷的快耀武扬威你了解什么情况反抗似的NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u200c\u2008\u200a";
        StaffAnalyzer.llllIlllII[9] = " : ";
        StaffAnalyzer.llllIlllII[10] = " : ";
    }
    
    private static String lIllIIIIlllI(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("DES")).init(2, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), 8), "DES"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String lIllIIIIllll(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("Blowfish")).init(2, new SecretKeySpec(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), "Blowfish"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String lIllIIIlIIII(String s, final String s2) {
        s = new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        final StringBuilder sb = new StringBuilder();
        final char[] charArray = s2.toCharArray();
        int n = 0;
        char[] charArray2;
        for (int length = (charArray2 = s.toCharArray()).length, i = 0; i < length; ++i) {
            sb.append((char)(charArray2[i] ^ charArray[n % charArray.length]));
            ++n;
        }
        return String.valueOf(sb);
    }
    
    private static boolean lIllIIlIIIlI(final int n, final int n2) {
        return n >= n2;
    }
}
