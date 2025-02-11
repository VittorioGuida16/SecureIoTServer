#ifndef _TRUSTANCHORS_H_
#define _TRUSTANCHORS_H_

#ifdef __cplusplus
extern "C"
{
#endif

/* This file is auto-generated by the pycert_bearssl tool.  Do not change it manually.
 * Certificates are BearSSL br_x509_trust_anchor format.  Included certs:
 *
 * Index:    0
 * Label:    server
 * Subject:  CN=server,OU=IoTServer,O=server-team,L=Salerno,ST=Salerno,C=IT
 * Type:     Certificate Authority
 */

#define TAs_NUM 1

static const unsigned char TA_DN0[] = {
    0x30, 0x6c, 0x31, 0x0b, 0x30, 0x09, 0x06, 0x03, 0x55, 0x04, 0x06, 0x13,
    0x02, 0x49, 0x54, 0x31, 0x10, 0x30, 0x0e, 0x06, 0x03, 0x55, 0x04, 0x08,
    0x13, 0x07, 0x53, 0x61, 0x6c, 0x65, 0x72, 0x6e, 0x6f, 0x31, 0x10, 0x30,
    0x0e, 0x06, 0x03, 0x55, 0x04, 0x07, 0x13, 0x07, 0x53, 0x61, 0x6c, 0x65,
    0x72, 0x6e, 0x6f, 0x31, 0x14, 0x30, 0x12, 0x06, 0x03, 0x55, 0x04, 0x0a,
    0x13, 0x0b, 0x73, 0x65, 0x72, 0x76, 0x65, 0x72, 0x2d, 0x74, 0x65, 0x61,
    0x6d, 0x31, 0x12, 0x30, 0x10, 0x06, 0x03, 0x55, 0x04, 0x0b, 0x13, 0x09,
    0x49, 0x6f, 0x54, 0x53, 0x65, 0x72, 0x76, 0x65, 0x72, 0x31, 0x0f, 0x30,
    0x0d, 0x06, 0x03, 0x55, 0x04, 0x03, 0x13, 0x06, 0x73, 0x65, 0x72, 0x76,
    0x65, 0x72,
};

static const unsigned char TA_RSA_N0[] = {
    0xd3, 0xf0, 0x5f, 0x7b, 0x98, 0x9c, 0xe7, 0xec, 0x8c, 0x4c, 0x45, 0x69,
    0x65, 0x4f, 0xb2, 0x2e, 0x74, 0xec, 0x19, 0xc7, 0xeb, 0xb9, 0x9e, 0x9b,
    0x36, 0x43, 0x84, 0x70, 0xfb, 0xfa, 0x4b, 0x40, 0x4c, 0x7e, 0x03, 0x97,
    0x24, 0x9f, 0x9d, 0xc8, 0x53, 0x8d, 0x3e, 0xfb, 0xd2, 0x60, 0x1d, 0x1e,
    0xa4, 0x61, 0xee, 0xd5, 0x70, 0x54, 0xdd, 0x6c, 0x9d, 0x02, 0xd5, 0x3a,
    0xcf, 0xb5, 0x03, 0xb6, 0x45, 0xd9, 0x74, 0x21, 0xee, 0xdd, 0xbf, 0x1c,
    0x88, 0xab, 0xa5, 0xa9, 0x22, 0x2d, 0x2f, 0xe6, 0x42, 0x62, 0x2e, 0x10,
    0x73, 0xc7, 0x80, 0x1d, 0xf1, 0xa7, 0xce, 0xa5, 0xe9, 0xec, 0xf4, 0xcb,
    0x15, 0x56, 0xc2, 0xbc, 0xb1, 0x54, 0x96, 0x78, 0x23, 0x26, 0x89, 0x18,
    0x1e, 0xb0, 0x83, 0xe5, 0x77, 0xd3, 0xd3, 0xc1, 0x62, 0x08, 0x17, 0x78,
    0x0e, 0xf6, 0x77, 0x87, 0x4b, 0x9f, 0xeb, 0xda, 0x85, 0x75, 0xaf, 0x0b,
    0xf1, 0xda, 0x8e, 0xda, 0xef, 0x27, 0xb2, 0xa7, 0xd4, 0xa0, 0xc8, 0x39,
    0xa3, 0x50, 0x65, 0xe1, 0xb9, 0xd5, 0xee, 0xc1, 0xe2, 0x68, 0x7b, 0xcc,
    0x11, 0xce, 0xac, 0xa3, 0x03, 0xd3, 0x3a, 0x35, 0x93, 0x00, 0x0f, 0x64,
    0x98, 0xf1, 0x28, 0xd1, 0x90, 0x06, 0xe8, 0xaa, 0x2e, 0xf9, 0x10, 0xc4,
    0x66, 0xd8, 0x56, 0xf5, 0x83, 0xe1, 0x02, 0xf0, 0x89, 0x78, 0xae, 0x4a,
    0x16, 0xe0, 0xc4, 0x5d, 0xe9, 0x3e, 0x35, 0x34, 0x87, 0x93, 0x75, 0x99,
    0xfa, 0x7a, 0xa9, 0x3f, 0x1b, 0xd9, 0x03, 0x31, 0xf6, 0xa5, 0xcc, 0xbe,
    0x56, 0x44, 0x92, 0x21, 0xbd, 0x8c, 0xf7, 0xc9, 0x2c, 0xf8, 0xcc, 0xf7,
    0xd4, 0xa0, 0x05, 0xd8, 0x21, 0xe8, 0x7f, 0xb4, 0x00, 0x47, 0xc7, 0x01,
    0x44, 0xa1, 0x0d, 0x5e, 0x32, 0xf7, 0x8a, 0x84, 0x11, 0xf4, 0x2c, 0x7a,
    0x00, 0x10, 0xcb, 0x45,
};

static const unsigned char TA_RSA_E0[] = {
    0x01, 0x00, 0x01,
};

static const br_x509_trust_anchor TAs[] = {
    {
        { (unsigned char *)TA_DN0, sizeof TA_DN0 },
        BR_X509_TA_CA,
        {
            BR_KEYTYPE_RSA,
            { .rsa = {
                (unsigned char *)TA_RSA_N0, sizeof TA_RSA_N0,
                (unsigned char *)TA_RSA_E0, sizeof TA_RSA_E0,
            } }
        }
    },
};

#ifdef __cplusplus
} /* extern "C" */
#endif

#endif /* ifndef _TRUSTANCHORS_H_ */
