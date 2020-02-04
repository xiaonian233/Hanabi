package ClassSub;

import java.util.*;

public final class Class169 implements Class16
{
    private long a;
    private int[] b;
    private Class16 c;
    private long d;
    private long[] j;
    private static long[] k;
    static int[] e;
    private static ArrayList f;
    private static Vector m;
    private static int i;
    private static Object o;
    private static int h;
    private static int l;
    private static int n;
    
    private static Object g() {
        return Class169.o;
    }
    
    public static Class16 a(final long n, final long n2, final Object o) {
        Class168.a$1385ff();
        final Class16 a = Class168.a(d(n), d(n2));
        if (o != null) {
            Class169.m.add(o);
        }
        return a;
    }
    
    static Class16 c(final long n) {
        final int n2;
        if ((n2 = (int)a$5b96a160(n, Class169.h, 63, Class169.e)) < Class169.i) {
            return (Class16)Class169.f.get(n2);
        }
        if (Class169.f.size() % Class169.l == 0) {
            Class169.e = Class169.e.clone();
        }
        final Class169 class169 = new Class169(n);
        Class169.f.add(class169);
        return class169;
    }
    
    private static Class16 d(final long n) {
        return new Class169(n);
    }
    
    static void a$3ef603ea() {
        Class169.i = Class169.f.size();
        c();
        Class168.d();
    }
    
    static void b$3ef603ea() {
        c();
        final int[] e = new int[64];
        (Class169.e = e)[0] = -19;
        e[1] = -31;
        e[2] = -44;
        e[3] = -21;
        e[4] = -29;
        e[5] = -11;
        e[6] = -55;
        e[7] = -37;
        e[8] = -3;
        e[9] = -25;
        e[10] = -26;
        e[11] = 3;
        e[12] = -1;
        e[13] = 1;
        e[15] = (e[14] = -8);
        e[16] = 11;
        e[17] = -28;
        e[18] = -7;
        e[19] = 19;
        e[20] = -19;
        e[21] = -14;
        e[23] = (e[22] = 8);
        e[24] = 21;
        e[25] = 7;
        e[26] = -22;
        e[27] = -31;
        e[28] = -9;
        e[29] = -30;
        e[30] = -22;
        e[31] = -7;
        e[32] = 31;
        e[33] = 29;
        e[34] = 25;
        e[35] = 14;
        e[36] = 26;
        e[37] = 9;
        e[38] = 7;
        e[39] = 19;
        e[40] = -16;
        e[41] = -21;
        e[42] = -5;
        e[43] = -14;
        e[44] = 37;
        e[45] = 28;
        e[46] = 44;
        e[47] = 5;
        e[48] = 22;
        e[49] = -5;
        e[50] = -10;
        e[51] = -2;
        e[52] = 22;
        e[53] = 2;
        e[54] = 5;
        e[55] = -8;
        e[56] = 16;
        e[57] = 14;
        e[58] = 31;
        e[59] = 30;
        e[60] = 10;
        e[61] = 55;
        e[62] = 21;
        e[63] = 8;
        Class168.c();
    }
    
    private Class169(final long a) {
        super();
        this.a = a;
        this.b = Class169.e;
    }
    
    @Override
    public final long a(final long n) {
        final long a = this.a(8, 55);
        this.a ^= (n ^ this.d);
        if (this.c != null) {
            this.c.a(n);
        }
        return a;
    }
    
    @Override
    public final void b(final long d) {
        this.d = d;
    }
    
    @Override
    public final void a(final Class16 c) {
        if (this != c) {
            if (this.c == null) {
                this.c = c;
                return;
            }
            this.c.a(c);
        }
    }
    
    @Override
    public final int hashCode() {
        return (int)this.a(8);
    }
    
    @Override
    public final boolean equals(final Object o) {
        return llIlIllllIll(this, o) || (o instanceof Class169 && this.a(56) == ((Class169)o).a(56));
    }
    
    @Override
    public final boolean b(final Class16 class16) {
        return llIlIllllIll(this, class16) || !(class16 instanceof Class169) || this.a(56, 63) - ((Class169)class16).a(56, 63) <= 0L;
    }
    
    @Override
    public final int[] b() {
        return this.b;
    }
    
    private long a(final int n) {
        return this.a(0, n - 1);
    }
    
    private long a(final int n, final int n2) {
        return a$5b96a160(this.a, n, n2, this.b);
    }
    
    private static long a$5b96a160(final long n, final int n2, final int n3, final int[] array) {
        long n4 = 0L;
        for (int length = array.length, i = 0; i < length; ++i) {
            long n5 = n & Class169.k[i];
            final int n6 = array[i];
            if (n5 != 0L) {
                if (n6 > 0) {
                    n5 >>>= n6;
                }
                else if (n6 < 0) {
                    n5 <<= ~n6 + 1;
                }
                n4 |= n5;
            }
        }
        long n7 = n4;
        final int n8;
        if ((n8 = 63 - n3) > 0) {
            n7 <<= n8;
        }
        final int n9;
        if ((n9 = n2 + 64 - 1 - n3) > 0) {
            n7 >>>= n9;
        }
        return n7;
    }
    
    private static void c() {
        a(0, Class169.f.size() - 1, Class169.f, new ArrayList(Class169.f), 0);
    }
    
    private static void a(final int n, final int n2, final ArrayList list, final ArrayList list2, int n3) {
        if (n < n2) {
            final int n4 = n + (n2 - n) / 2;
            if (++n3 < Class169.n) {
                a(n, n4, list, list2, n3);
                a(n4 + 1, n2, list, list2, n3);
            }
            a(n, n4, n2, list, list2);
        }
    }
    
    private static void a(int n, final int n2, final int n3, final ArrayList list, final ArrayList list2) {
        int n4 = n;
        int n5 = n2 + 1;
        for (int n6 = n; llIllIIIIIIl(n6, n3); ++n6) {
            list2.set(n6, list.get(n6));
        }
        while (llIllIIIIIIl(n4, n2) && llIllIIIIIIl(n5, n3)) {
            Class16 class16;
            if (list2.get(n4).b(list2.get(n5))) {
                class16 = list2.get(n4++);
            }
            else {
                class16 = list2.get(n5++);
            }
            list.set(n, class16);
            ++n;
        }
        while (llIllIIIIIIl(n4, n2)) {
            list.set(n, list2.get(n4));
            ++n;
            ++n4;
        }
    }
    
    static {
        Class169.h = 52;
        Class169.n = 17;
        Class169.l = 128;
        Class169.k = new long[64];
        long n = 1L;
        for (int i = 0; i < 64; ++i) {
            Class169.k[i] = n;
            n <<= 1;
        }
        Class169.o = new Object();
        Class169.m = new Vector();
        Class169.f = new ArrayList();
        a0();
        Class169.i = Class169.f.size();
        c();
    }
    
    private static void a0() {
        Class169.e = new int[] { -16, -50, -32, -17, -6, -7, -31, -40, -6, -41, 6, -12, 7, -48, 6, -45, 16, -21, -28, -2, 17, 2, -32, 12, -39, -10, -3, -16, -25, 3, -22, -2, -16, 2, 32, 10, -4, 31, 21, -18, 4, -17, -3, 16, -11, 3, 28, 40, 16, -13, 41, 50, 22, 25, 32, 11, -3, 18, 17, 3, 45, 48, 13, 39 };
        Class169.f.add(new Class169(4261294780845905429L));
        Class169.f.add(new Class169(-4278696297608962883L));
        Class169.f.add(new Class169(-7580634439710822586L));
        Class169.f.add(new Class169(6723639322618493535L));
        Class169.f.add(new Class169(3684834578281518613L));
        Class169.f.add(new Class169(9213288503162378265L));
        Class169.f.add(new Class169(4848596786772048539L));
        Class169.f.add(new Class169(8107930668716027502L));
        Class169.f.add(new Class169(8197719790201062096L));
        Class169.f.add(new Class169(-7508574096877080762L));
        Class169.f.add(new Class169(5077776140755034780L));
        Class169.f.add(new Class169(6324923663737027427L));
        Class169.f.add(new Class169(3279409081567198526L));
        Class169.f.add(new Class169(8711414173969415870L));
        Class169.f.add(new Class169(-1714985662989151565L));
        Class169.f.add(new Class169(-4851806691664661110L));
        Class169.f.add(new Class169(6929600741785553902L));
        Class169.f.add(new Class169(6318459530139029691L));
        Class169.f.add(new Class169(1137799610862834981L));
        Class169.f.add(new Class169(-6089918930649831523L));
        Class169.f.add(new Class169(-8554080955413472365L));
        Class169.f.add(new Class169(-1524527334374798059L));
        Class169.f.add(new Class169(8343799552937664945L));
        Class169.f.add(new Class169(6456862300120200580L));
        Class169.f.add(new Class169(-4401594454666422053L));
        Class169.f.add(new Class169(3976756067707061444L));
        Class169.f.add(new Class169(-5590574060785407952L));
        Class169.f.add(new Class169(2190454827519444359L));
        Class169.f.add(new Class169(-8714913995930908627L));
        Class169.f.add(new Class169(-838367126745351541L));
        Class169.f.add(new Class169(3801476190066817872L));
        Class169.f.add(new Class169(6765184565818666508L));
        Class169.f.add(new Class169(-4019488633208054451L));
        Class169.f.add(new Class169(5318087051737298531L));
        Class169.f.add(new Class169(-4446693642242022447L));
        Class169.f.add(new Class169(-6101525546787805996L));
        Class169.f.add(new Class169(1447430875992086934L));
        Class169.f.add(new Class169(4798339875419559218L));
        Class169.f.add(new Class169(-6665817282772432995L));
        Class169.f.add(new Class169(2929077298960020713L));
        Class169.f.add(new Class169(4950130696256773834L));
        Class169.f.add(new Class169(1310526578469029527L));
        Class169.f.add(new Class169(-4828973035930672346L));
        Class169.f.add(new Class169(-1927386168085504927L));
        Class169.f.add(new Class169(-8426609948378410540L));
        Class169.f.add(new Class169(-4712968162216686310L));
        Class169.f.add(new Class169(184585506822768419L));
        Class169.f.add(new Class169(-4604213523506052413L));
        Class169.f.add(new Class169(-4584694480934470290L));
        Class169.f.add(new Class169(-4469742923816833757L));
        Class169.f.add(new Class169(-5794468912632489432L));
        Class169.f.add(new Class169(8717048353409619607L));
        Class169.f.add(new Class169(518793831933645841L));
        Class169.f.add(new Class169(-3512174303304680130L));
        Class169.f.add(new Class169(-5333269645200623717L));
        Class169.f.add(new Class169(2309502434747377613L));
        Class169.f.add(new Class169(-5297135998871391875L));
        Class169.f.add(new Class169(-5388755454549100073L));
        Class169.f.add(new Class169(6509287974293849511L));
        Class169.f.add(new Class169(1701767169638339231L));
        Class169.f.add(new Class169(-6079638297774155102L));
        Class169.f.add(new Class169(6787771004579097730L));
        Class169.f.add(new Class169(3059076268394950744L));
        Class169.f.add(new Class169(1114762867319127044L));
        Class169.f.add(new Class169(-994122609738678089L));
        Class169.f.add(new Class169(-1967826727182609996L));
        Class169.f.add(new Class169(-2601204740954976153L));
        Class169.f.add(new Class169(6596402374549188040L));
        Class169.f.add(new Class169(-7201462020973736786L));
        Class169.f.add(new Class169(44303156355555282L));
        Class169.f.add(new Class169(-8524811873703853445L));
        Class169.f.add(new Class169(162274794516577659L));
        Class169.f.add(new Class169(6257797092468538237L));
        Class169.f.add(new Class169(-8337389465117261739L));
        Class169.f.add(new Class169(4090606060822146560L));
        Class169.f.add(new Class169(-4090179795049078296L));
        Class169.f.add(new Class169(-5338806038147533842L));
        Class169.f.add(new Class169(6359508930529916301L));
        Class169.f.add(new Class169(-7219715516252421043L));
        Class169.f.add(new Class169(-2672874852944725028L));
        Class169.f.add(new Class169(7049295285355617601L));
        Class169.f.add(new Class169(-5348436623133904145L));
        Class169.f.add(new Class169(-8553105105615472267L));
        Class169.f.add(new Class169(-3946692663414495859L));
        Class169.f.add(new Class169(5049248568128106144L));
        Class169.f.add(new Class169(4831382116766568221L));
        Class169.f.add(new Class169(-256660445863087997L));
        Class169.f.add(new Class169(-3115879098625308913L));
        Class169.f.add(new Class169(1548753089306212605L));
        Class169.f.add(new Class169(-8560986295183372294L));
        Class169.f.add(new Class169(919416035190629236L));
        Class169.f.add(new Class169(-4077374386134297269L));
        Class169.f.add(new Class169(-8200799112288816059L));
        Class169.f.add(new Class169(1461353802666931653L));
        Class169.f.add(new Class169(-3363089356588311447L));
        Class169.f.add(new Class169(5747626510285551251L));
        Class169.f.add(new Class169(3282224770906405750L));
        Class169.f.add(new Class169(2572230689134727036L));
        Class169.f.add(new Class169(1449177686910069092L));
        Class169.f.add(new Class169(-1468098127923944265L));
        Class169.f.add(new Class169(6295012734891643400L));
        Class169.f.add(new Class169(2444657261576246992L));
        Class169.f.add(new Class169(-9136215487505945037L));
        Class169.f.add(new Class169(-7327380020222092498L));
        Class169.f.add(new Class169(3987766357105314234L));
        Class169.f.add(new Class169(-5724626823556465441L));
        Class169.f.add(new Class169(-7163672879612581452L));
        Class169.f.add(new Class169(4997675882611890688L));
        Class169.f.add(new Class169(1947398812281846879L));
        Class169.f.add(new Class169(-7512769012146750077L));
        Class169.f.add(new Class169(-4746504512999311220L));
        Class169.f.add(new Class169(-4773522762999026482L));
        Class169.f.add(new Class169(4714741708885761450L));
        Class169.f.add(new Class169(4055212918835332799L));
        Class169.f.add(new Class169(3431358371254308965L));
        Class169.f.add(new Class169(-6562290531260914076L));
        Class169.f.add(new Class169(8372971123921883683L));
        Class169.f.add(new Class169(-707023811590387201L));
        Class169.f.add(new Class169(-543126097113900393L));
        Class169.f.add(new Class169(1126753277603381902L));
        Class169.f.add(new Class169(3066357324601682554L));
        Class169.f.add(new Class169(-3850950682047777061L));
        Class169.f.add(new Class169(-6582389540860174772L));
        Class169.f.add(new Class169(8232969827044543085L));
        Class169.f.add(new Class169(5697766914469449376L));
        Class169.f.add(new Class169(-7922909468870656612L));
        Class169.f.add(new Class169(6556086737768782953L));
        Class169.f.add(new Class169(6511677693391168479L));
        Class169.f.add(new Class169(8064132144402806531L));
        Class169.f.add(new Class169(-3980996452751896657L));
        Class169.f.add(new Class169(971795142061007029L));
        Class169.f.add(new Class169(-428005857309545858L));
        Class169.f.add(new Class169(-1809347514055937277L));
        Class169.f.add(new Class169(3592009390164679716L));
        Class169.f.add(new Class169(3725226841251226481L));
        Class169.f.add(new Class169(6698478160186285954L));
        Class169.f.add(new Class169(8806658855689083760L));
        Class169.f.add(new Class169(-6445806056915378482L));
        Class169.f.add(new Class169(-5376410030058466164L));
        Class169.f.add(new Class169(200376877324485354L));
        Class169.f.add(new Class169(-4630574803167609888L));
        Class169.f.add(new Class169(252354551047554232L));
        Class169.f.add(new Class169(-5968554739890572154L));
        Class169.f.add(new Class169(6683281455627235225L));
        Class169.f.add(new Class169(6087219306244059792L));
        Class169.f.add(new Class169(6370694124035357334L));
        Class169.f.add(new Class169(6302682619324377875L));
        Class169.f.add(new Class169(-2299293570103720054L));
        Class169.f.add(new Class169(7038791415067186810L));
        Class169.f.add(new Class169(1174256265748390744L));
        Class169.f.add(new Class169(-3940505901276605313L));
        Class169.f.add(new Class169(5971994230934536013L));
        Class169.f.add(new Class169(-6089728725933207108L));
        Class169.f.add(new Class169(-2870092554696703758L));
        Class169.f.add(new Class169(-6299576243858435606L));
        Class169.f.add(new Class169(-8487518732692972898L));
        Class169.f.add(new Class169(5518460324120017709L));
        Class169.f.add(new Class169(3696159128963366334L));
        Class169.f.add(new Class169(-2067002006524216809L));
        Class169.f.add(new Class169(-5732824704491352649L));
        Class169.f.add(new Class169(267910121096419878L));
        Class169.f.add(new Class169(-4459256008883595949L));
        Class169.f.add(new Class169(-4302971357597559220L));
        Class169.f.add(new Class169(5886348665944818998L));
        Class169.f.add(new Class169(-6254263504103296452L));
        Class169.f.add(new Class169(6656087879527899742L));
        Class169.f.add(new Class169(-6849481121464175045L));
        Class169.f.add(new Class169(1615049555697456861L));
        Class169.f.add(new Class169(8768554429254346201L));
        Class169.f.add(new Class169(-2731150728369328320L));
        Class169.f.add(new Class169(-3597941631333760435L));
        Class169.f.add(new Class169(-5637856282184241286L));
        Class169.f.add(new Class169(8636547541408648563L));
        Class169.f.add(new Class169(1626609233198982826L));
        Class169.e = Class169.e.clone();
        Class169.f.add(new Class169(-9146799634166506917L));
        Class169.f.add(new Class169(3409485106854074005L));
        Class169.f.add(new Class169(2085776403677688843L));
        Class169.f.add(new Class169(-6315797025079947160L));
        Class169.f.add(new Class169(7446823767547566630L));
        Class169.f.add(new Class169(-3987009731980579797L));
        Class169.f.add(new Class169(-8005493147965617836L));
        Class169.f.add(new Class169(-5970249384400111271L));
        Class169.f.add(new Class169(337423409538013846L));
        Class169.f.add(new Class169(205030020484365284L));
        Class169.f.add(new Class169(7292489279021449735L));
        Class169.f.add(new Class169(4905278066027901926L));
        Class169.f.add(new Class169(4295112028946348329L));
        Class169.f.add(new Class169(-4422840467371769531L));
        Class169.f.add(new Class169(265059548504470000L));
        Class169.f.add(new Class169(-7082953020477935812L));
        Class169.f.add(new Class169(3486176116449456949L));
        Class169.f.add(new Class169(7179197169304348350L));
        Class169.f.add(new Class169(1310528777509029527L));
        Class169.f.add(new Class169(1611492290600545891L));
        Class169.f.add(new Class169(6438927377491456153L));
        Class169.f.add(new Class169(3880592504722228853L));
        Class169.f.add(new Class169(-417989454909472326L));
        Class169.f.add(new Class169(-2984541769043642383L));
        Class169.f.add(new Class169(7724698392831940423L));
        Class169.f.add(new Class169(-6313367914985297225L));
        Class169.f.add(new Class169(-7353065893534832472L));
        Class169.f.add(new Class169(5691156088389903044L));
        Class169.f.add(new Class169(5398979529213645428L));
        Class169.f.add(new Class169(-7718908799399297747L));
        Class169.f.add(new Class169(-4219623029500552122L));
        Class169.f.add(new Class169(4271047447717474629L));
        Class169.f.add(new Class169(6009823087559870305L));
        Class169.f.add(new Class169(-2258832894346283701L));
        Class169.f.add(new Class169(4814842175068887671L));
        Class169.f.add(new Class169(3180529465544666314L));
        Class169.f.add(new Class169(3775721306404854375L));
        Class169.f.add(new Class169(-1747036162118983319L));
        Class169.f.add(new Class169(3040528843426868246L));
        Class169.f.add(new Class169(8872379129005659453L));
        Class169.f.add(new Class169(3424611954514709688L));
        Class169.f.add(new Class169(-3241132102989232391L));
        Class169.f.add(new Class169(8424843967211138799L));
        Class169.f.add(new Class169(12074171475378494L));
        Class169.f.add(new Class169(-2764947546243317848L));
        Class169.f.add(new Class169(-4446483792399048108L));
        Class169.f.add(new Class169(-5895059446610118159L));
        Class169.f.add(new Class169(7683402129960730795L));
        Class169.f.add(new Class169(-2630866660625497190L));
        Class169.f.add(new Class169(4107957206572131606L));
        Class169.f.add(new Class169(-3772629925188605928L));
        Class169.f.add(new Class169(8210286382779290930L));
        Class169.f.add(new Class169(-7011744078811990419L));
        Class169.f.add(new Class169(3618434723956809654L));
        Class169.f.add(new Class169(3291863130348013108L));
        Class169.f.add(new Class169(-6400526967469933360L));
        Class169.f.add(new Class169(1080487076312350649L));
        Class169.f.add(new Class169(2917429959813116725L));
        Class169.f.add(new Class169(-8432165460915932796L));
        Class169.f.add(new Class169(2926672466051788900L));
        Class169.f.add(new Class169(484208555998706966L));
        Class169.f.add(new Class169(3109046815021118603L));
        Class169.f.add(new Class169(-2271325845005178654L));
        Class169.f.add(new Class169(-6016523934283537297L));
        Class169.f.add(new Class169(-1020341286419927443L));
        Class169.f.add(new Class169(8631764268319137985L));
        Class169.f.add(new Class169(-4988826865546909067L));
        Class169.f.add(new Class169(8784251772259810566L));
        Class169.f.add(new Class169(-356582449555696963L));
        Class169.f.add(new Class169(1298879916184681567L));
        Class169.f.add(new Class169(-8146481281646589537L));
        Class169.f.add(new Class169(3987212338326144660L));
        Class169.f.add(new Class169(-4676067300405477121L));
        Class169.f.add(new Class169(8318826658101198128L));
        Class169.f.add(new Class169(-6376976185319636421L));
        Class169.f.add(new Class169(-1610283032794709057L));
        Class169.f.add(new Class169(3416165623714056264L));
        Class169.f.add(new Class169(3435868656888012295L));
        Class169.f.add(new Class169(-7566947138677052198L));
        Class169.f.add(new Class169(-122605693288982709L));
        Class169.f.add(new Class169(640043157281811324L));
        Class169.f.add(new Class169(-3815870094984641415L));
        Class169.f.add(new Class169(807140816024385041L));
        Class169.f.add(new Class169(-3508433581047588833L));
        Class169.f.add(new Class169(-4392511641073060864L));
        Class169.f.add(new Class169(-6290642450817395459L));
        Class169.f.add(new Class169(-8502462213227032476L));
        Class169.f.add(new Class169(-3458785473476042434L));
        Class169.f.add(new Class169(-7129712290607204411L));
        Class169.f.add(new Class169(-3820129204499652066L));
        Class169.f.add(new Class169(-2023268170534958290L));
        Class169.f.add(new Class169(-4374989148314582444L));
        Class169.f.add(new Class169(-989719471919727262L));
        Class169.f.add(new Class169(-4848603019676924024L));
        Class169.f.add(new Class169(-8724096726233264962L));
        Class169.f.add(new Class169(2198156172942967535L));
        Class169.f.add(new Class169(8656912158135076409L));
        Class169.f.add(new Class169(6038745375726977000L));
        Class169.f.add(new Class169(-3771447365473739193L));
        Class169.f.add(new Class169(-2431443188668743365L));
        Class169.f.add(new Class169(3651972676334203048L));
        Class169.f.add(new Class169(8745111671689650707L));
        Class169.f.add(new Class169(-6497144389513464235L));
        Class169.f.add(new Class169(494311388815448178L));
        Class169.f.add(new Class169(-7475291511648369894L));
        Class169.f.add(new Class169(8051206809624866972L));
        Class169.f.add(new Class169(5500176763813442960L));
        Class169.f.add(new Class169(-303357301048399043L));
        Class169.f.add(new Class169(-6078481379061492083L));
        Class169.f.add(new Class169(6919852782063107013L));
        Class169.f.add(new Class169(8916436564804971477L));
        Class169.f.add(new Class169(-7549790240944238052L));
        Class169.f.add(new Class169(-1652638063032305618L));
        Class169.f.add(new Class169(1782196580712178788L));
        Class169.f.add(new Class169(3057143865723561628L));
        Class169.f.add(new Class169(260938744006396613L));
        Class169.f.add(new Class169(5806633016879963180L));
        Class169.f.add(new Class169(-8399901376574290007L));
        Class169.f.add(new Class169(-3453975179578730046L));
        Class169.f.add(new Class169(9175381043745562454L));
        Class169.f.add(new Class169(914273237663714096L));
        Class169.f.add(new Class169(2151780191759237578L));
        Class169.f.add(new Class169(-5309520450753940389L));
        Class169.f.add(new Class169(2221440559213430721L));
        Class169.f.add(new Class169(3111042993703248931L));
        Class169.f.add(new Class169(-7515974579536100811L));
        Class169.f.add(new Class169(-8881859388049413687L));
        Class169.f.add(new Class169(-5149223329785382836L));
        Class169.f.add(new Class169(3665735198146108617L));
        Class169.f.add(new Class169(8876924483845935381L));
        Class169.f.add(new Class169(3532125499397435188L));
        Class169.f.add(new Class169(1123515302693706426L));
        Class169.f.add(new Class169(-4515560119504873280L));
        Class169.f.add(new Class169(7424401765118409528L));
        Class169.f.add(new Class169(6148224954329440141L));
        Class169.f.add(new Class169(7463915225707746217L));
        Class169.f.add(new Class169(7171962225145723595L));
        Class169.f.add(new Class169(-1953988868089098425L));
        Class169.f.add(new Class169(-1565351373704639963L));
        Class169.f.add(new Class169(-1661328629759988107L));
        Class169.f.add(new Class169(-2591010651040583529L));
        Class169.f.add(new Class169(-5626255019047113459L));
        Class169.f.add(new Class169(1340959301770822479L));
        Class169.f.add(new Class169(-3680810439032110601L));
        Class169.f.add(new Class169(1406921931547602664L));
        Class169.f.add(new Class169(3581032241132512194L));
        Class169.f.add(new Class169(-7420199445113490591L));
        Class169.f.add(new Class169(-5546975295642400198L));
        Class169.f.add(new Class169(4018380022351889613L));
        Class169.f.add(new Class169(7625205229222560318L));
        Class169.f.add(new Class169(4657865196830730061L));
        Class169.f.add(new Class169(-1448500912729491348L));
        Class169.f.add(new Class169(-6857105786009603093L));
        Class169.f.add(new Class169(6496140834994226974L));
        Class169.f.add(new Class169(5195834094632750482L));
        Class169.f.add(new Class169(-8314090730730628716L));
        Class169.f.add(new Class169(-8333097318178526722L));
        Class169.f.add(new Class169(-6187726896453111577L));
        Class169.f.add(new Class169(-9002931869922426179L));
        Class169.f.add(new Class169(1267457011765629468L));
        Class169.f.add(new Class169(6663682257570730640L));
        Class169.f.add(new Class169(6247697512969112936L));
        Class169.f.add(new Class169(-412851042767809747L));
        Class169.f.add(new Class169(5743292299249143557L));
        Class169.f.add(new Class169(-2104888216586353875L));
        Class169.f.add(new Class169(-1816236028598400757L));
        Class169.f.add(new Class169(5230064869297583777L));
        Class169.f.add(new Class169(6121838392640464988L));
        Class169.f.add(new Class169(-3661170182668957450L));
        Class169.f.add(new Class169(-2969057829477095890L));
        Class169.f.add(new Class169(-3462280318971414458L));
        Class169.f.add(new Class169(1897537422634604186L));
        Class169.f.add(new Class169(192680428463601244L));
        Class169.f.add(new Class169(6689724156895409886L));
        Class169.f.add(new Class169(-4975840004412690479L));
        Class169.f.add(new Class169(-55686283976676831L));
        Class169.f.add(new Class169(-4995249870843085009L));
        Class169.f.add(new Class169(7053461964953112799L));
        Class169.f.add(new Class169(3262477981452639168L));
        Class169.f.add(new Class169(8182063380383695645L));
        Class169.f.add(new Class169(-2101808351882825160L));
        Class169.f.add(new Class169(-2084389210841866943L));
        Class169.f.add(new Class169(8296414564991733937L));
        Class169.f.add(new Class169(-1600597523349150759L));
        Class169.f.add(new Class169(-6764189298023976729L));
        Class169.f.add(new Class169(8795254765542538285L));
        Class169.e = Class169.e.clone();
        Class169.f.add(new Class169(-5253749745430731402L));
        Class169.f.add(new Class169(6394339539664290017L));
        Class169.f.add(new Class169(-7009624902209827657L));
        Class169.f.add(new Class169(7590025184668007997L));
        Class169.f.add(new Class169(-7078801235253940219L));
        Class169.f.add(new Class169(5276883540814665254L));
        Class169.f.add(new Class169(4404733074310338210L));
        Class169.f.add(new Class169(3450181197091179790L));
        Class169.f.add(new Class169(564190445821382814L));
        Class169.f.add(new Class169(-306861352575407292L));
        Class169.f.add(new Class169(2646400857887499803L));
        Class169.f.add(new Class169(2104662947317746309L));
        Class169.f.add(new Class169(5035378825917203678L));
        Class169.f.add(new Class169(-3204017139076924194L));
        Class169.f.add(new Class169(6756217573532866874L));
        Class169.f.add(new Class169(1886426030086440599L));
        Class169.f.add(new Class169(7773897762025696146L));
        Class169.f.add(new Class169(8106388673988824833L));
        Class169.f.add(new Class169(-4741855728970447255L));
        Class169.f.add(new Class169(6530199401110036806L));
        Class169.f.add(new Class169(-5270124037899520023L));
        Class169.f.add(new Class169(1213805484478941130L));
        Class169.f.add(new Class169(7387780072275077618L));
        Class169.f.add(new Class169(-989721670943015582L));
        Class169.f.add(new Class169(-3917847812949962533L));
        Class169.f.add(new Class169(5685798898881540628L));
        Class169.f.add(new Class169(2490890832986292545L));
        Class169.f.add(new Class169(5131091961672681479L));
        Class169.f.add(new Class169(-687424821701189173L));
        Class169.f.add(new Class169(-2880706760786489107L));
        Class169.f.add(new Class169(-7398564997680608593L));
        Class169.f.add(new Class169(-5373554044852139097L));
        Class169.f.add(new Class169(8599421739107605026L));
        Class169.f.add(new Class169(-4101741410471577467L));
        Class169.f.add(new Class169(-4630367473035662194L));
        Class169.f.add(new Class169(6700873586487067624L));
        Class169.f.add(new Class169(-3428738178561947858L));
        Class169.f.add(new Class169(4126017296431143220L));
        Class169.f.add(new Class169(2542648704876147383L));
        Class169.f.add(new Class169(49439411533140939L));
        Class169.f.add(new Class169(-2620764257775587886L));
        Class169.f.add(new Class169(-538634851570882520L));
        Class169.f.add(new Class169(-4840452072454841907L));
        Class169.f.add(new Class169(4100743221099184247L));
        Class169.f.add(new Class169(-1755374097954224079L));
        Class169.f.add(new Class169(-3532922195077754002L));
        Class169.f.add(new Class169(8007118862926917005L));
        Class169.f.add(new Class169(312272182274788202L));
        Class169.f.add(new Class169(3075515243269313413L));
        Class169.f.add(new Class169(-3826780990251400717L));
        Class169.f.add(new Class169(-8413730325436261684L));
        Class169.f.add(new Class169(-422694164930244672L));
        Class169.f.add(new Class169(-1738055836111971920L));
        Class169.f.add(new Class169(-4871262056276430781L));
        Class169.f.add(new Class169(9113119227722247003L));
        Class169.f.add(new Class169(-525078689369403665L));
        Class169.f.add(new Class169(3951143986069427521L));
        Class169.f.add(new Class169(-5056966355535955239L));
        Class169.f.add(new Class169(7288549583210622711L));
        Class169.f.add(new Class169(-5423516329904337868L));
        Class169.f.add(new Class169(-692983337404090467L));
        Class169.f.add(new Class169(8930791645742568723L));
        Class169.f.add(new Class169(-5201620474948358748L));
        Class169.f.add(new Class169(3678997906156806921L));
        Class169.f.add(new Class169(7909072804338164561L));
        Class169.f.add(new Class169(-3673724427140469061L));
        Class169.f.add(new Class169(2108495031319112625L));
        Class169.f.add(new Class169(-2834518248949144757L));
        Class169.f.add(new Class169(8359354453671302291L));
        Class169.f.add(new Class169(-3791219949162185502L));
        Class169.f.add(new Class169(-4260464029235966710L));
        Class169.f.add(new Class169(1873367046591021833L));
        Class169.f.add(new Class169(-6794592537063230035L));
        Class169.f.add(new Class169(3354492003986568805L));
        Class169.f.add(new Class169(-5506243343462730257L));
        Class169.f.add(new Class169(-7078633326265186501L));
        Class169.f.add(new Class169(7003355847235941536L));
        Class169.f.add(new Class169(-3952220728851239465L));
        Class169.f.add(new Class169(-1564011412606930623L));
        Class169.f.add(new Class169(2370688169094858358L));
        Class169.f.add(new Class169(-216055836757433722L));
        Class169.f.add(new Class169(7123080701513274224L));
        Class169.f.add(new Class169(-2272488202290984625L));
        Class169.f.add(new Class169(3947096852721470558L));
        Class169.f.add(new Class169(2905537449700010661L));
        Class169.f.add(new Class169(-4519396141646107538L));
        Class169.f.add(new Class169(2975344201076397261L));
        Class169.f.add(new Class169(9032584524161291530L));
        Class169.f.add(new Class169(-6600656168622793533L));
        Class169.f.add(new Class169(2747589913774368065L));
        Class169.f.add(new Class169(4804884159567469538L));
        Class169.f.add(new Class169(8990210539038357198L));
        Class169.f.add(new Class169(6061896410283028694L));
        Class169.f.add(new Class169(-6217633239193938808L));
        Class169.f.add(new Class169(-7404187438577204513L));
        Class169.f.add(new Class169(-1404020229082344606L));
        Class169.f.add(new Class169(1061002268721546756L));
        Class169.f.add(new Class169(-8112379730740803640L));
        Class169.f.add(new Class169(3221094166258121822L));
        Class169.f.add(new Class169(1853985826043368850L));
        Class169.f.add(new Class169(-4527901849545575576L));
        Class169.f.add(new Class169(-2184333918962985023L));
        Class169.f.add(new Class169(8754403662941653149L));
        Class169.f.add(new Class169(8405140331200715583L));
        Class169.f.add(new Class169(-4037498670905398788L));
        Class169.f.add(new Class169(5969000005281237301L));
        Class169.f.add(new Class169(2385693154652214937L));
        Class169.f.add(new Class169(-882971625911596559L));
        Class169.f.add(new Class169(-7758420429802272821L));
        Class169.f.add(new Class169(-7281194185588004633L));
        Class169.f.add(new Class169(7126915092524372570L));
        Class169.f.add(new Class169(4795534425892400184L));
        Class169.f.add(new Class169(4397429613243030683L));
        Class169.f.add(new Class169(-2013026198650019142L));
        Class169.f.add(new Class169(1800736477601163639L));
        Class169.f.add(new Class169(-2583541339662041546L));
        Class169.f.add(new Class169(-7851662609901526730L));
        Class169.f.add(new Class169(4352743096858357018L));
        Class169.f.add(new Class169(7366237904496908618L));
        Class169.f.add(new Class169(-2723832540544435094L));
        Class169.f.add(new Class169(8933010091733600650L));
        Class169.f.add(new Class169(-4370706101746043208L));
        Class169.f.add(new Class169(-936004829162301839L));
        Class169.f.add(new Class169(773296854980213951L));
        Class169.f.add(new Class169(6156395680889359355L));
        Class169.f.add(new Class169(-6679770732634428997L));
        Class169.f.add(new Class169(-281529198325965945L));
        Class169.f.add(new Class169(-8424750103443181242L));
        Class169.f.add(new Class169(-2237019836091392286L));
        Class169.f.add(new Class169(3252845706609917376L));
        Class169.f.add(new Class169(5981100527178727042L));
        Class169.f.add(new Class169(717168609172904292L));
        Class169.f.add(new Class169(-3824243456996789581L));
        Class169.f.add(new Class169(5790650528287864013L));
        Class169.f.add(new Class169(1908136343710595629L));
        Class169.f.add(new Class169(4867730152520458134L));
        Class169.f.add(new Class169(8269390311140963266L));
        Class169.f.add(new Class169(4712746782869028980L));
        Class169.f.add(new Class169(-6677885975406582918L));
        Class169.f.add(new Class169(-2908690015701181492L));
        Class169.f.add(new Class169(8762606245468303251L));
        Class169.f.add(new Class169(6550463989972826425L));
        Class169.f.add(new Class169(1955625108719490428L));
        Class169.f.add(new Class169(7628726215477842568L));
        Class169.f.add(new Class169(-3853770135787476309L));
        Class169.f.add(new Class169(-1084122764887421813L));
        Class169.f.add(new Class169(-6541855514633492696L));
        Class169.f.add(new Class169(8137727724921769049L));
        Class169.f.add(new Class169(5847096921063798272L));
        Class169.f.add(new Class169(858467886266832836L));
        Class169.f.add(new Class169(706261170893489595L));
        Class169.f.add(new Class169(9050172173830305743L));
        Class169.f.add(new Class169(4555050717742856461L));
        Class169.f.add(new Class169(-6180928044958735296L));
        Class169.f.add(new Class169(-4036272564224038976L));
        Class169.f.add(new Class169(-7293366089972458336L));
        Class169.f.add(new Class169(1306369883326062587L));
        Class169.f.add(new Class169(-2960966052869833262L));
        Class169.f.add(new Class169(-3143494974639085701L));
        Class169.f.add(new Class169(3741161142865432084L));
        Class169.f.add(new Class169(1165738450902831157L));
        Class169.f.add(new Class169(7413356536701221944L));
        Class169.f.add(new Class169(3836543576611261904L));
        Class169.f.add(new Class169(6756915598808429354L));
        Class169.f.add(new Class169(-4395723310942469876L));
        Class169.f.add(new Class169(-5309625395886257693L));
        Class169.f.add(new Class169(4088111202562638038L));
        Class169.f.add(new Class169(5700049282627378051L));
        Class169.f.add(new Class169(-6806505165565137752L));
        Class169.f.add(new Class169(-1240241027398606410L));
        Class169.f.add(new Class169(1435749827961429188L));
        Class169.f.add(new Class169(-2981053956988439792L));
        Class169.f.add(new Class169(-5432606131237915966L));
        Class169.f.add(new Class169(-4404925183530052388L));
        Class169.f.add(new Class169(9213854201911654425L));
        Class169.f.add(new Class169(-8299768155124028026L));
        Class169.f.add(new Class169(-91261255742750320L));
        Class169.f.add(new Class169(-4838552386116848710L));
        Class169.f.add(new Class169(7698524759570094986L));
        Class169.f.add(new Class169(4852712573843227087L));
        Class169.f.add(new Class169(-2302568394334103872L));
        Class169.f.add(new Class169(-1092223627662841096L));
        Class169.f.add(new Class169(-66073481050976046L));
        Class169.e = Class169.e.clone();
        Class169.f.add(new Class169(-4120813422304588167L));
        Class169.f.add(new Class169(-5861080930535511897L));
        Class169.f.add(new Class169(4899470984512708905L));
        Class169.f.add(new Class169(5340720425838565451L));
        Class169.f.add(new Class169(-6633089975740417192L));
        Class169.f.add(new Class169(-9002929670882360643L));
        Class169.f.add(new Class169(-1690778537426454908L));
        Class169.f.add(new Class169(17537598777121910L));
        Class169.f.add(new Class169(751964960188334258L));
        Class169.f.add(new Class169(-4660757878304721860L));
        Class169.f.add(new Class169(-2477292398308342428L));
        Class169.f.add(new Class169(-7248497695131625109L));
        Class169.f.add(new Class169(5731964050682512055L));
        Class169.f.add(new Class169(447911866624804151L));
        Class169.f.add(new Class169(-8637963552130350963L));
        Class169.f.add(new Class169(-8681031134491324447L));
        Class169.f.add(new Class169(5346487248082772110L));
        Class169.f.add(new Class169(5830579727610897243L));
        Class169.f.add(new Class169(-3494333556904191200L));
        Class169.f.add(new Class169(5926496716668134597L));
        Class169.f.add(new Class169(-2903303065361255976L));
        Class169.f.add(new Class169(4628376518465207612L));
        Class169.f.add(new Class169(3332677769718720349L));
        Class169.f.add(new Class169(-4088244799997507839L));
        Class169.f.add(new Class169(1964032281553560474L));
        Class169.f.add(new Class169(4636711923035333938L));
        Class169.f.add(new Class169(-2938370572763359627L));
        Class169.f.add(new Class169(-1283873567608782407L));
        Class169.f.add(new Class169(3855235937941381463L));
        Class169.f.add(new Class169(501201657029599424L));
        Class169.f.add(new Class169(6165923593007612431L));
        Class169.f.add(new Class169(-2427142277350926461L));
        Class169.f.add(new Class169(2296663748597509333L));
        Class169.f.add(new Class169(2544797308573066804L));
        Class169.f.add(new Class169(3485824510927991726L));
        Class169.f.add(new Class169(1125830062504177857L));
        Class169.f.add(new Class169(5757820340289560992L));
        Class169.f.add(new Class169(-4250363312849033655L));
        Class169.f.add(new Class169(-3678973145908616235L));
        Class169.f.add(new Class169(-3521703254373175297L));
        Class169.f.add(new Class169(-705086735108351956L));
        Class169.f.add(new Class169(2556124399202065698L));
        Class169.f.add(new Class169(-9101094050987859323L));
        Class169.f.add(new Class169(5852610402602480263L));
        Class169.f.add(new Class169(3864691387510597381L));
        Class169.f.add(new Class169(-602669465904134074L));
        Class169.f.add(new Class169(8023282320827701798L));
        Class169.f.add(new Class169(-4826165537685913325L));
        Class169.f.add(new Class169(-4165227091217978913L));
        Class169.f.add(new Class169(1068668066790514340L));
        Class169.f.add(new Class169(7091313438903556748L));
        Class169.f.add(new Class169(6702948071202028089L));
        Class169.f.add(new Class169(468870517658143777L));
        Class169.f.add(new Class169(-3426697596605663099L));
        Class169.f.add(new Class169(-2582307492790335215L));
        Class169.f.add(new Class169(5099450317434930939L));
        Class169.f.add(new Class169(203942880947937768L));
        Class169.f.add(new Class169(-3618465535548515804L));
        Class169.f.add(new Class169(9129261699940978986L));
        Class169.f.add(new Class169(-9068230019669645259L));
        Class169.f.add(new Class169(-8937131569118080636L));
        Class169.f.add(new Class169(-4799768048624945375L));
        Class169.f.add(new Class169(-3769009122138968729L));
        Class169.f.add(new Class169(-483064431549927456L));
        Class169.f.add(new Class169(8942265806741787820L));
        Class169.f.add(new Class169(5052553911036651877L));
        Class169.f.add(new Class169(-9033115827755031956L));
        Class169.f.add(new Class169(8040594378502063651L));
        Class169.f.add(new Class169(-7799127926641274227L));
        Class169.f.add(new Class169(6543958567889401579L));
        Class169.f.add(new Class169(4295428063735492000L));
        Class169.f.add(new Class169(505745071840563442L));
        Class169.f.add(new Class169(7824666660852940893L));
        Class169.f.add(new Class169(6016678532481207992L));
        Class169.f.add(new Class169(3697677524920824634L));
        Class169.f.add(new Class169(527664103985501149L));
        Class169.f.add(new Class169(2808499108560265371L));
        Class169.f.add(new Class169(4936692088292679430L));
        Class169.f.add(new Class169(-6294448021241995275L));
        Class169.f.add(new Class169(4340948933883203024L));
        Class169.f.add(new Class169(-7594045550160029648L));
        Class169.f.add(new Class169(-93371407953466077L));
        Class169.f.add(new Class169(8977401156642951805L));
        Class169.f.add(new Class169(-1881091568746719277L));
        Class169.f.add(new Class169(-7323857516157899839L));
        Class169.f.add(new Class169(6993317164975938915L));
        Class169.f.add(new Class169(27763623175654430L));
        Class169.f.add(new Class169(-7124046318424889535L));
        Class169.f.add(new Class169(3295700003307948009L));
        Class169.f.add(new Class169(-7968942305901017689L));
        Class169.f.add(new Class169(3455506429396188399L));
        Class169.f.add(new Class169(8680938635270862515L));
        Class169.f.add(new Class169(4635163393673564941L));
        Class169.f.add(new Class169(-4467253811892321542L));
        Class169.f.add(new Class169(8402530761021431115L));
        Class169.f.add(new Class169(-7559808161847750237L));
        Class169.f.add(new Class169(7967151507015301719L));
        Class169.f.add(new Class169(6912335497742595609L));
        Class169.f.add(new Class169(5301833664754558544L));
        Class169.f.add(new Class169(-8622693512158507175L));
        Class169.f.add(new Class169(761743299671625649L));
        Class169.f.add(new Class169(1605900812883222909L));
        Class169.f.add(new Class169(-812160842649611049L));
        Class169.f.add(new Class169(5616598491165100419L));
        Class169.f.add(new Class169(-4691046910985976875L));
        Class169.f.add(new Class169(-6805009084324955926L));
        Class169.f.add(new Class169(-3178907590816603493L));
        Class169.f.add(new Class169(4052009355876303526L));
        Class169.f.add(new Class169(-101217924769552997L));
        Class169.f.add(new Class169(-8978160813889759550L));
        Class169.f.add(new Class169(-8848925490522260095L));
        Class169.f.add(new Class169(-6328776832100245296L));
        Class169.f.add(new Class169(-2928668530869310867L));
        Class169.f.add(new Class169(1935502102905471915L));
        Class169.f.add(new Class169(-8925662419614472107L));
        Class169.f.add(new Class169(-3876914205075599934L));
        Class169.f.add(new Class169(6263885881710014560L));
        Class169.f.add(new Class169(-8181771130192543713L));
        Class169.f.add(new Class169(-5986478175801366644L));
        Class169.f.add(new Class169(-4276999361704632496L));
        Class169.f.add(new Class169(-1927497834156425794L));
        Class169.f.add(new Class169(3831058334645509038L));
        Class169.f.add(new Class169(-7847331583163852788L));
        Class169.f.add(new Class169(4548687380425481918L));
        Class169.f.add(new Class169(985172867570936458L));
        Class169.f.add(new Class169(-1909270395106601196L));
        Class169.f.add(new Class169(-5463660497178959166L));
        Class169.f.add(new Class169(-9008042652406907292L));
        Class169.f.add(new Class169(8362353765189938240L));
        Class169.f.add(new Class169(3465317040603491887L));
        Class169.f.add(new Class169(-7299514433051734222L));
        Class169.f.add(new Class169(164034161498049908L));
        Class169.f.add(new Class169(-7089857840380414483L));
        Class169.f.add(new Class169(7203771225999474178L));
        Class169.f.add(new Class169(-9043895376621460423L));
        Class169.f.add(new Class169(7325009871572534927L));
        Class169.f.add(new Class169(-3430714359598765483L));
        Class169.f.add(new Class169(-1031351193935568072L));
        Class169.f.add(new Class169(-6093428062690580893L));
        Class169.f.add(new Class169(6554499226053806327L));
        Class169.f.add(new Class169(-2663937830495899283L));
        Class169.f.add(new Class169(9143121669764077059L));
        Class169.f.add(new Class169(-2222099039966143832L));
        Class169.f.add(new Class169(-2900159896807125371L));
        Class169.f.add(new Class169(7421170946945316061L));
        Class169.f.add(new Class169(4550369759304533360L));
        Class169.f.add(new Class169(-1888259212098270772L));
        Class169.f.add(new Class169(-3683548619269422404L));
        Class169.f.add(new Class169(-5780994111913789652L));
        Class169.f.add(new Class169(-3593474859319748012L));
        Class169.f.add(new Class169(8836219867334180023L));
        Class169.f.add(new Class169(-9048531817741559117L));
        Class169.f.add(new Class169(-4426576626412515193L));
        Class169.f.add(new Class169(7885310496432998175L));
        Class169.f.add(new Class169(-4607974175342995631L));
        Class169.f.add(new Class169(1859052934769570357L));
        Class169.f.add(new Class169(4532838028838052494L));
        Class169.f.add(new Class169(-8039505995154120327L));
        Class169.f.add(new Class169(4900068452168521553L));
        Class169.e = Class169.e.clone();
        Class169.f.add(new Class169(5327059195105646538L));
        Class169.f.add(new Class169(215579726533073230L));
        Class169.f.add(new Class169(8953232206821181513L));
        Class169.f.add(new Class169(-2215347315563604428L));
        Class169.f.add(new Class169(-1014751152182758736L));
        Class169.f.add(new Class169(-2954701066572626456L));
        Class169.f.add(new Class169(-5924397883857897702L));
        Class169.f.add(new Class169(2746577542377562298L));
        Class169.f.add(new Class169(3324727286490907006L));
        Class169.f.add(new Class169(1291489072120878135L));
        Class169.f.add(new Class169(6853291335802573142L));
        Class169.f.add(new Class169(-444800527718238229L));
        Class169.f.add(new Class169(7495299957216227455L));
        Class169.f.add(new Class169(-5647545773516043503L));
        Class169.f.add(new Class169(3795904654955035889L));
        Class169.f.add(new Class169(-6171645931072180458L));
        Class169.f.add(new Class169(-89389341903426434L));
        Class169.f.add(new Class169(-4556160323058238547L));
        Class169.f.add(new Class169(2699815964131901838L));
        Class169.f.add(new Class169(7937986349498502777L));
        Class169.f.add(new Class169(7339005812786948912L));
        Class169.f.add(new Class169(-8793372106795622943L));
        Class169.f.add(new Class169(-8672868363133566995L));
        Class169.f.add(new Class169(4108526689080947283L));
        Class169.f.add(new Class169(2908631736982964569L));
        Class169.f.add(new Class169(7210481715414158890L));
        Class169.f.add(new Class169(1129358370356623559L));
        Class169.f.add(new Class169(-1970734801792696555L));
        Class169.f.add(new Class169(4814818929384748660L));
        Class169.f.add(new Class169(-2393838899117556208L));
        Class169.f.add(new Class169(-7851101309198778058L));
        Class169.f.add(new Class169(7488483205622375153L));
        Class169.f.add(new Class169(6608975438142857183L));
        Class169.f.add(new Class169(1770211284961665175L));
        Class169.f.add(new Class169(148178116527529813L));
        Class169.f.add(new Class169(3369124104319407103L));
        Class169.f.add(new Class169(8279392732963093144L));
        Class169.f.add(new Class169(-7155575294409984106L));
        Class169.f.add(new Class169(-5763259747111151463L));
        Class169.f.add(new Class169(-4035260399258893719L));
        Class169.f.add(new Class169(5229600933777032233L));
        Class169.f.add(new Class169(-8547231728074593771L));
        Class169.f.add(new Class169(4150032495190491778L));
        Class169.f.add(new Class169(-5318572756600546646L));
        Class169.f.add(new Class169(-7650806159270801416L));
        Class169.f.add(new Class169(-6410371283190753215L));
        Class169.f.add(new Class169(1643927252940490832L));
        Class169.f.add(new Class169(8779567089866336914L));
        Class169.f.add(new Class169(1541936472481771620L));
        Class169.f.add(new Class169(2796853707993280496L));
        Class169.f.add(new Class169(-4769936750436086690L));
        Class169.f.add(new Class169(7489176725204669122L));
        Class169.f.add(new Class169(7780265789299517574L));
        Class169.f.add(new Class169(-5512884249271365895L));
        Class169.f.add(new Class169(4365093319651379189L));
        Class169.f.add(new Class169(-6086961551859288207L));
        Class169.f.add(new Class169(-5843197278930989068L));
        Class169.f.add(new Class169(4200311193316652264L));
        Class169.f.add(new Class169(-5985312534309876516L));
        Class169.f.add(new Class169(-3820411044008573999L));
        Class169.f.add(new Class169(-1980246092684455242L));
        Class169.f.add(new Class169(-5417789170455563075L));
        Class169.f.add(new Class169(9148574936588159230L));
        Class169.f.add(new Class169(7401385578547324410L));
        Class169.f.add(new Class169(175787016172724101L));
        Class169.f.add(new Class169(-7220112567022317197L));
        Class169.f.add(new Class169(2568572088582994810L));
        Class169.f.add(new Class169(-8323977405320401213L));
        Class169.f.add(new Class169(-8828664603260609473L));
        Class169.f.add(new Class169(9186652194447776165L));
        Class169.f.add(new Class169(1475226041383303465L));
        Class169.f.add(new Class169(-7528286564163891738L));
        Class169.f.add(new Class169(-4501875416536317340L));
        Class169.f.add(new Class169(8561132377516057300L));
        Class169.f.add(new Class169(-783623489883760061L));
        Class169.f.add(new Class169(-7305175807570707455L));
        Class169.f.add(new Class169(5670464859365016063L));
        Class169.f.add(new Class169(-1101726329755129972L));
        Class169.f.add(new Class169(-3972382398993867333L));
        Class169.f.add(new Class169(532595047054684365L));
        Class169.f.add(new Class169(4657542128827285392L));
        Class169.f.add(new Class169(-8430092114155350881L));
        Class169.f.add(new Class169(-9184127547626835586L));
        Class169.f.add(new Class169(1344936176032615028L));
        Class169.f.add(new Class169(2695631749844489168L));
        Class169.f.add(new Class169(-8768000369703423416L));
        Class169.f.add(new Class169(-6012966538617247860L));
        Class169.f.add(new Class169(-5939677843421844068L));
        Class169.f.add(new Class169(-6809184451212244885L));
        Class169.f.add(new Class169(2658957888632112919L));
        Class169.f.add(new Class169(-3643401161252830837L));
        Class169.f.add(new Class169(2018043549493319064L));
        Class169.f.add(new Class169(-5727833793920825581L));
        Class169.f.add(new Class169(-3306400576714450830L));
        Class169.f.add(new Class169(1696631567558955929L));
        Class169.f.add(new Class169(595505020297249020L));
        Class169.f.add(new Class169(-4407389459374809741L));
        Class169.f.add(new Class169(7978137515979608099L));
        Class169.f.add(new Class169(-150819545735227258L));
        Class169.f.add(new Class169(-2527816166635057039L));
        Class169.f.add(new Class169(-285445090178717826L));
        Class169.f.add(new Class169(-1587726712699412580L));
        Class169.f.add(new Class169(-3497810349310399963L));
        Class169.f.add(new Class169(-6954854016179004098L));
        Class169.f.add(new Class169(5899260281181023791L));
        Class169.f.add(new Class169(-383218797204740746L));
        Class169.f.add(new Class169(3411024661225198263L));
        Class169.f.add(new Class169(-8784798147424136525L));
        Class169.f.add(new Class169(9069593713028251751L));
        Class169.f.add(new Class169(2803707609815222825L));
        Class169.f.add(new Class169(-1626525509794606215L));
        Class169.f.add(new Class169(-7258986233655922796L));
        Class169.f.add(new Class169(2689608983915308135L));
        Class169.f.add(new Class169(-5571119713596281202L));
        Class169.f.add(new Class169(-3730278427476475984L));
        Class169.f.add(new Class169(-1114074321713458827L));
        Class169.f.add(new Class169(6178206245744515375L));
        Class169.f.add(new Class169(-6745300737131512341L));
        Class169.f.add(new Class169(-8677483265853090655L));
        Class169.f.add(new Class169(5120314347246712729L));
        Class169.f.add(new Class169(-7833622492452073845L));
        Class169.f.add(new Class169(-1670403207358868263L));
        Class169.f.add(new Class169(-1281238349673219160L));
        Class169.f.add(new Class169(-4105579421594801587L));
        Class169.f.add(new Class169(8588437374086191384L));
        Class169.f.add(new Class169(7834342853251601413L));
        Class169.f.add(new Class169(-6948478663148488083L));
        Class169.f.add(new Class169(1059902489330819101L));
        Class169.f.add(new Class169(3336613895703116108L));
        Class169.f.add(new Class169(3006903172001013597L));
        Class169.f.add(new Class169(-1819487259072579397L));
        Class169.f.add(new Class169(-860803839440313519L));
        Class169.f.add(new Class169(-824399521407220494L));
        Class169.f.add(new Class169(-5503709022342943683L));
        Class169.f.add(new Class169(-7625150104336622118L));
        Class169.f.add(new Class169(8126682920290142661L));
        Class169.f.add(new Class169(1481418906903596575L));
        Class169.f.add(new Class169(-1372787667400204558L));
        Class169.f.add(new Class169(6658713939346180647L));
        Class169.f.add(new Class169(4227801613292299441L));
        Class169.f.add(new Class169(6761312408162436867L));
        Class169.f.add(new Class169(-6135684066994978508L));
        Class169.f.add(new Class169(-7650839661925955740L));
        Class169.f.add(new Class169(840943155190031249L));
        Class169.f.add(new Class169(4709653786220641599L));
        Class169.f.add(new Class169(-3821261123167789731L));
        Class169.f.add(new Class169(721808382240975270L));
        Class169.f.add(new Class169(361952217624980296L));
        Class169.f.add(new Class169(611580521348206598L));
        Class169.f.add(new Class169(848410998014601451L));
        Class169.f.add(new Class169(1145296055575804415L));
        Class169.f.add(new Class169(7211991086068081467L));
        Class169.f.add(new Class169(-2261218141751635681L));
        Class169.f.add(new Class169(2705761819596495734L));
        Class169.f.add(new Class169(-5354105267427975490L));
        Class169.f.add(new Class169(-606738494335059692L));
        Class169.f.add(new Class169(2626271236009942746L));
        Class169.f.add(new Class169(3220754489507751121L));
        Class169.f.add(new Class169(3202166839336664794L));
        Class169.f.add(new Class169(-5220333879492589050L));
        Class169.f.add(new Class169(-4274512311411440819L));
        Class169.f.add(new Class169(8516133099816538685L));
        Class169.f.add(new Class169(2992467288412829966L));
        Class169.f.add(new Class169(-4347480571164807782L));
        Class169.f.add(new Class169(-4856838043430720380L));
        Class169.f.add(new Class169(2519695875055079291L));
        Class169.f.add(new Class169(1590623706175981147L));
        Class169.f.add(new Class169(1734275949236846153L));
        Class169.f.add(new Class169(8535174925235695891L));
        Class169.f.add(new Class169(4645886336502218690L));
        Class169.f.add(new Class169(-2605387659069936194L));
        Class169.f.add(new Class169(3620544585661628369L));
        Class169.f.add(new Class169(8980644249392921339L));
        Class169.f.add(new Class169(-2411322199705457927L));
        Class169.f.add(new Class169(2638597199620068031L));
        Class169.f.add(new Class169(8130163769898303535L));
        Class169.f.add(new Class169(-5155802651518759497L));
        Class169.f.add(new Class169(-8647493455091308813L));
        Class169.f.add(new Class169(3410260498313327460L));
        Class169.f.add(new Class169(-2870023742080172722L));
        Class169.f.add(new Class169(-35531643441016546L));
        Class169.f.add(new Class169(315966845267090205L));
        Class169.f.add(new Class169(3450404578213126403L));
        Class169.f.add(new Class169(201360444603358934L));
        Class169.f.add(new Class169(6734861368164429568L));
        Class169.f.add(new Class169(4509301942251588247L));
        Class169.e = Class169.e.clone();
        Class169.f.add(new Class169(2355539097077408825L));
        Class169.f.add(new Class169(6332425613488515058L));
        Class169.f.add(new Class169(-9014400163021180532L));
        Class169.f.add(new Class169(-1074659251596071113L));
        Class169.f.add(new Class169(3297236836745168432L));
        Class169.f.add(new Class169(-8570305849853213253L));
        Class169.f.add(new Class169(-2055716791950847139L));
        Class169.f.add(new Class169(-4827922736811208997L));
        Class169.f.add(new Class169(-7147692352849533922L));
        Class169.f.add(new Class169(120445267601098067L));
        Class169.f.add(new Class169(-5018053080169430520L));
        Class169.f.add(new Class169(-4386559041935566051L));
        Class169.f.add(new Class169(-2104194571876653443L));
        Class169.f.add(new Class169(-3429199482219963189L));
        Class169.f.add(new Class169(7440836517316285895L));
        Class169.f.add(new Class169(1017392973474942337L));
        Class169.f.add(new Class169(-8845373376677860904L));
        Class169.f.add(new Class169(6481635117970434212L));
        Class169.f.add(new Class169(-254584496222637595L));
        Class169.f.add(new Class169(-2748519893325164105L));
        Class169.f.add(new Class169(-850471979970957213L));
        Class169.f.add(new Class169(4876484515713399408L));
        Class169.f.add(new Class169(560771763177286152L));
        Class169.f.add(new Class169(1998830292454659651L));
        Class169.f.add(new Class169(-7997395411730930360L));
        Class169.f.add(new Class169(-3424341836847660000L));
        Class169.f.add(new Class169(-582110659294609994L));
        Class169.f.add(new Class169(7294229748996654956L));
        Class169.f.add(new Class169(-3267384617169239268L));
        Class169.f.add(new Class169(-5046278754163131028L));
        Class169.f.add(new Class169(4338483499410305250L));
        Class169.f.add(new Class169(3428871100686527123L));
        Class169.f.add(new Class169(5877672018802058282L));
        Class169.f.add(new Class169(-1346892304207537595L));
        Class169.f.add(new Class169(776454351376309349L));
        Class169.f.add(new Class169(9209728085324422457L));
        Class169.f.add(new Class169(-2363004914378350874L));
        Class169.f.add(new Class169(1440980306608344665L));
        Class169.f.add(new Class169(1854092670274627959L));
        Class169.f.add(new Class169(2735320682964925743L));
        Class169.f.add(new Class169(-8052739489052203239L));
        Class169.f.add(new Class169(123120746824748283L));
        Class169.f.add(new Class169(1833931754331652830L));
        Class169.f.add(new Class169(-8131346131199179797L));
        Class169.f.add(new Class169(-1896422764211337179L));
        Class169.f.add(new Class169(3003795765684099377L));
        Class169.f.add(new Class169(-7767434729522169823L));
        Class169.f.add(new Class169(-2941937486923117370L));
        Class169.f.add(new Class169(7012501118715400529L));
        Class169.f.add(new Class169(1424414301794383695L));
        Class169.f.add(new Class169(-5085583644863616457L));
        Class169.f.add(new Class169(-5913254940255130404L));
        Class169.f.add(new Class169(6222330830924646862L));
        Class169.f.add(new Class169(-3709555140857395229L));
        Class169.f.add(new Class169(260544204226628969L));
        Class169.f.add(new Class169(294825764227156593L));
        Class169.f.add(new Class169(5391417776636878071L));
        Class169.f.add(new Class169(-3976430501652846196L));
        Class169.f.add(new Class169(6960006098362834620L));
        Class169.f.add(new Class169(-3206061315207107844L));
        Class169.f.add(new Class169(-5847711641249722827L));
        Class169.f.add(new Class169(-1053558085689708659L));
        Class169.f.add(new Class169(-5192704166964588500L));
        Class169.f.add(new Class169(7383065626281052923L));
        Class169.f.add(new Class169(4533587803107108322L));
        Class169.f.add(new Class169(765791874786863978L));
        Class169.f.add(new Class169(2997568837131949436L));
        Class169.f.add(new Class169(-6950451088842068279L));
        Class169.f.add(new Class169(-7516037578701033332L));
        Class169.f.add(new Class169(-8905962737041765886L));
        Class169.f.add(new Class169(6006465399117443757L));
        Class169.f.add(new Class169(-4053132029453462559L));
        Class169.f.add(new Class169(-3414989320194485095L));
        Class169.f.add(new Class169(-5022555005586819339L));
        Class169.f.add(new Class169(4691354122497405377L));
        Class169.f.add(new Class169(-3767575108177210933L));
        Class169.f.add(new Class169(2826719635567536008L));
        Class169.f.add(new Class169(-3130584561873208394L));
        Class169.f.add(new Class169(1588298120358991272L));
        Class169.f.add(new Class169(4988900678809546732L));
        Class169.f.add(new Class169(-7698964287298183397L));
        Class169.f.add(new Class169(-43694272841689478L));
        Class169.f.add(new Class169(-3730793970072736635L));
        Class169.f.add(new Class169(-556356320232059729L));
        Class169.f.add(new Class169(-9107420414228369L));
        Class169.f.add(new Class169(7514478255510703041L));
        Class169.f.add(new Class169(3635755848069921200L));
        Class169.f.add(new Class169(-2460724005053623933L));
        Class169.e = Class169.e.clone();
        Class169.f.add(new Class169(2343047791120063671L));
        Class169.f.add(new Class169(418629971221800990L));
        Class169.f.add(new Class169(-6905279051233792395L));
        Class169.f.add(new Class169(3329719036424757272L));
        Class169.f.add(new Class169(7052430764146891095L));
        Class169.f.add(new Class169(-1142182873957930991L));
        Class169.f.add(new Class169(4386517745936643732L));
        Class169.f.add(new Class169(-8838547659815591149L));
        Class169.f.add(new Class169(-6988454224546078565L));
        Class169.f.add(new Class169(-2233463994655010573L));
        Class169.f.add(new Class169(-2683816188869948474L));
        Class169.f.add(new Class169(932222595265284241L));
        Class169.f.add(new Class169(9086511351949083440L));
        Class169.f.add(new Class169(5453028364729971466L));
        Class169.f.add(new Class169(25689021086409050L));
        Class169.f.add(new Class169(-6409214273781663491L));
        Class169.f.add(new Class169(3042303355129448012L));
        Class169.f.add(new Class169(-5503429034864373156L));
        Class169.f.add(new Class169(-6174705504719274209L));
        Class169.f.add(new Class169(5452246857759708630L));
        Class169.f.add(new Class169(-1302905524577158912L));
        Class169.f.add(new Class169(-7014100775046159852L));
        Class169.f.add(new Class169(5508889831440379749L));
        Class169.f.add(new Class169(-5003838643143557804L));
        Class169.f.add(new Class169(6872426334578715310L));
        Class169.f.add(new Class169(5215178617817154015L));
        Class169.f.add(new Class169(-1735452434739358153L));
        Class169.f.add(new Class169(-676801256906492274L));
        Class169.f.add(new Class169(-753964207253981642L));
        Class169.f.add(new Class169(-1885479044334196076L));
        Class169.f.add(new Class169(397021762672332903L));
        Class169.f.add(new Class169(-7704564677232780553L));
        Class169.f.add(new Class169(-7825352180769192661L));
        Class169.f.add(new Class169(-8007910742114007721L));
        Class169.f.add(new Class169(-6351157887190820724L));
        Class169.f.add(new Class169(-8964026503095171648L));
        Class169.f.add(new Class169(3972888757966812589L));
        Class169.f.add(new Class169(8314747785665104665L));
        Class169.f.add(new Class169(7643609055022475317L));
        Class169.f.add(new Class169(-499263587109112428L));
        Class169.f.add(new Class169(3486154117288221346L));
        Class169.f.add(new Class169(-2221175242206894504L));
        Class169.f.add(new Class169(7658374770539508316L));
        Class169.f.add(new Class169(6026528039867747252L));
        Class169.f.add(new Class169(-3197588523035550817L));
        Class169.f.add(new Class169(8235998081750077567L));
        Class169.f.add(new Class169(8870450841401522995L));
        Class169.f.add(new Class169(-2823576478464451343L));
        Class169.e = new int[] { -34, -19, -19, -41, -58, -24, -51, -35, -20, -45, -51, -7, -19, -37, -12, -26, -22, -32, 7, -16, 19, 19, -24, -28, -15, -2, 12, 2, 20, 24, -17, 19, -26, -22, 34, 16, -12, -8, 22, 15, -3, 26, 35, 3, 41, 8, 24, 17, 12, 32, 37, 28, -1, 1, 45, 22, -4, 51, 26, -4, 4, 51, 58, 4 };
    }
    
    private static boolean llIllIIIIIIl(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean llIlIllllIII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean llIlIllllIll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean llIllIIIIIII(final int n) {
        return n < 0;
    }
    
    private static boolean llIlIllllllI(final int n) {
        return n <= 0;
    }
    
    private static boolean llIlIlllIlII(final int n) {
        return n > 0;
    }
    
    private static int llIlIlllIIll$2566aa8(final long n) {
        return lcmp(n, 0L);
    }
    
    private static int llIlIllllIlI(final long n, final long n2) {
        return lcmp(n, n2);
    }
    
    private static int llIlIlllllIl$2566aa8(final long n) {
        return lcmp(n, 0L);
    }
    
    private static int llIlIlllllll$2566aa8(final long n) {
        return lcmp(n, 0L);
    }
}
