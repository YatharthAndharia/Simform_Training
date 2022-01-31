function rotateLeft(str, n)
{
    return (str << n) | (str >>> (32 - n));
}
function hexToString(hex)
{
    var str = "", temp;
    for (var i = 7; i >= 0; i--) {
        temp = (hex >>> (i * 4)) & 0xf;
        str += temp.toString(16);
    }
    return str;
}
function calculateHash(msg)
{
    var H0 = 0x67452301;
    var H1 = 0xefcdab89;
    var H2 = 0x98badcfe;
    var H3 = 0x10325476;
    var H4 = 0xc3d2e1f0;
    var K = [0x5a827999, 0x6ed9eba1, 0x8f1bbcdc, 0xca62c1d6];

    // preprocessing
    msg += String.fromCharCode(0x80);  // add trailing '1' bit + 0's padding to string
    // convert string msg into 512-bit chunks
    var msg_len = msg.length / 4 + 2;  // length in 32-bit integers
    var N = Math.ceil(msg_len / 16);   // No of 512 bits required for whole msg
    var M = new Array(N);      // size of M is total 512 bits blocks required for whole msg.
    for (var i = 0; i < N; i++) {
        M[i] = new Array(16);   // each 512 bit block is converted to 16 words 32 bits each.
        for (var j = 0; j < 16; j++) {
            M[i][j] = (msg.charCodeAt(i * 64 + j * 4) << 24) | (msg.charCodeAt(i * 64 + j * 4 + 1) << 16) |
                (msg.charCodeAt(i * 64 + j * 4 + 2) << 8) | (msg.charCodeAt(i * 64 + j * 4 + 3));
        }
    }
    M[N - 1][15] = ((msg.length - 1) * 8) & 0xffffffff;

    var round = new Array(80);
    var a, b, c, d, e;
    for (var i = 0; i < N; i++) {
        for (var j = 0; j < 16; j++)
            round[j] = M[i][j];
        for (var j = 16; j < 80; j++)
            round[j] = rotateLeft(round[j - 3] ^ round[j - 8] ^ round[j - 14] ^ round[j - 16], 1);

        a = H0;
        b = H1;
        c = H2;
        d = H3;
        e = H4;
        var f, k;
        for (var j = 0; j < 80; j++) {
            if (j >= 0 && j <= 19) {
                f = (b & c) ^ (~b & d);
                k = K[0];
            }
            else if (j >= 20 && j <= 39) {
                f = b ^ c ^ d;
                k = K[1];
            }
            else if (j >= 40 && j <= 59) {
                f = (b & c) ^ (b & d) ^ (c & d);
                k = K[2];
            }
            else if (j >= 60 && j <= 79) {
                f = b ^ c ^ d;
                k = K[3];
            }
            var Temp = (rotateLeft(a, 5) + f + e + k + round[j]);
            e = d;
            d = c;
            c = rotateLeft(b, 30);
            b = a;
            a = Temp;
        }
        H0 = (H0 + a);
        H1 = (H1 + b);
        H2 = (H2 + c);
        H3 = (H3 + d);
        H4 = (H4 + e);

        return hexToString(H0) + hexToString(H1) + hexToString(H2) + hexToString(H3) + hexToString(H4);
    }
}
export {calculateHash};
//<script type="module" src="Blockchain.js"></script>