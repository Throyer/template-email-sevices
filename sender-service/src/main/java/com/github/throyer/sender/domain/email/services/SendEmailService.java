package com.github.throyer.sender.domain.email.services;

import com.samskivert.mustache.Mustache;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SendEmailService {
    public String email() {

        var template = """
<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:v="urn:schemas-microsoft-com:vml"
  xmlns:o="urn:schemas-microsoft-com:office:office">

<head>
  <title></title>
  <!--[if !mso]><!-->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!--<![endif]-->
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <style type="text/css">
    #outlook a {
      padding: 0;
    }

    body {
      margin: 0;
      padding: 0;
      -webkit-text-size-adjust: 100%;
      -ms-text-size-adjust: 100%;
    }

    table,
    td {
      border-collapse: collapse;
      mso-table-lspace: 0pt;
      mso-table-rspace: 0pt;
    }

    img {
      border: 0;
      height: auto;
      line-height: 100%;
      outline: none;
      text-decoration: none;
      -ms-interpolation-mode: bicubic;
    }

    p {
      display: block;
      margin: 0;
    }
  </style>
  <!--[if mso]> <noscript><xml><o:OfficeDocumentSettings><o:AllowPNG/><o:PixelsPerInch>96</o:PixelsPerInch></o:OfficeDocumentSettings></xml></noscript>
<![endif]-->
  <!--[if lte mso 11]>
<style type="text/css">
.ogf{width:100% !important;}
</style>
<![endif]-->
  <!--[if !mso]><!-->
  <link href="https://fonts.googleapis.com/css?family=Montserrat:500,600,700,800,400" rel="stylesheet" type="text/css">
  <style type="text/css">

  </style>
  <!--<![endif]-->
  <style type="text/css">
    @media only screen and (min-width:659px) {
      .pc100 {
        width: 100% !important;
        max-width: 100%;
      }

      .xc600 {
        width: 600px !important;
        max-width: 600px;
      }

      .pc24-404761904761905 {
        width: 24.404761904761905% !important;
        max-width: 24.404761904761905%;
      }

      .pc0-6613754090808687 {
        width: 0.6613754090808687% !important;
        max-width: 0.6613754090808687%;
      }

      .pc0-5952380952380952 {
        width: 0.5952380952380952% !important;
        max-width: 0.5952380952380952%;
      }

      .xc582 {
        width: 582px !important;
        max-width: 582px;
      }
    }
  </style>
  <style media="screen and (min-width:659px)">
    .moz-text-html .pc100 {
      width: 100% !important;
      max-width: 100%;
    }

    .moz-text-html .xc600 {
      width: 600px !important;
      max-width: 600px;
    }

    .moz-text-html .pc24-404761904761905 {
      width: 24.404761904761905% !important;
      max-width: 24.404761904761905%;
    }

    .moz-text-html .pc0-6613754090808687 {
      width: 0.6613754090808687% !important;
      max-width: 0.6613754090808687%;
    }

    .moz-text-html .pc0-5952380952380952 {
      width: 0.5952380952380952% !important;
      max-width: 0.5952380952380952%;
    }

    .moz-text-html .xc582 {
      width: 582px !important;
      max-width: 582px;
    }
  </style>
  <style type="text/css">
    @media only screen and (max-width:659px) {
      table.fwm {
        width: 100% !important;
      }

      td.fwm {
        width: auto !important;
      }
    }
  </style>
  <style type="text/css">
    u+.emailify a,
    #MessageViewBody a,
    a[x-apple-data-detectors] {
      color: inherit !important;
      text-decoration: none !important;
      font-size: inherit !important;
      font-family: inherit !important;
      font-weight: inherit !important;
      line-height: inherit !important;
    }

    span.MsoHyperlink {
      mso-style-priority: 99;
      color: inherit;
    }

    span.MsoHyperlinkFollowed {
      mso-style-priority: 99;
      color: inherit;
    }

    u+.emailify .glist {
      margin-left: 0 !important;
    }

    @media only screen and (max-width:659px) {
      .emailify {
        height: 100% !important;
        margin: 0 !important;
        padding: 0 !important;
        width: 100% !important;
      }

      u+.emailify .glist {
        margin-left: 25px !important;
      }

      td.x {
        padding-left: 0 !important;
        padding-right: 0 !important;
      }

      br.sb {
        display: none !important;
      }

      .hd-1 {
        display: block !important;
        height: auto !important;
        overflow: visible !important;
      }

      .ht-1 {
        display: table !important;
        height: auto !important;
        overflow: visible !important;
      }

      .hr-1 {
        display: table-row !important;
        height: auto !important;
        overflow: visible !important;
      }

      .hc-1 {
        display: table-cell !important;
        height: auto !important;
        overflow: visible !important;
      }

      div.r.pr-16>table>tbody>tr>td {
        padding-right: 16px !important
      }

      div.r.pl-16>table>tbody>tr>td {
        padding-left: 16px !important
      }

      .hm-1 {
        display: none !important;
        max-width: 0 !important;
        max-height: 0 !important;
        overflow: hidden !important;
        mso-hide: all !important;
      }

      td.i.w-75 img {
        width: 75px !important
      }

      td.x.fs-13 span,
      td.x.fs-13>div,
      td.x.fs-13 {
        font-size: 13px !important
      }

      td.x.lh-14 span,
      td.x.lh-14>div,
      td.x.lh-14 {
        line-height: 14px !important
      }

      div.r.pt-0>table>tbody>tr>td {
        padding-top: 0px !important
      }

      div.r.pr-0>table>tbody>tr>td {
        padding-right: 0px !important
      }

      div.r.pb-0>table>tbody>tr>td {
        padding-bottom: 0px !important
      }

      div.r.pl-0>table>tbody>tr>td {
        padding-left: 0px !important
      }
    }
  </style>
  <meta name="color-scheme" content="light dark">
  <meta name="supported-color-schemes" content="light dark">
  <!--[if gte mso 9]>
<style>li{text-indent:-1em;}
</style>
<![endif]-->
</head>

<body link="#DD0000" vlink="#DD0000" class="emailify" style="word-spacing:normal;background-color:#fff;">
  <div style="background-color:#fff;">
    <!--[if mso | IE]>
<table align="center" border="0" cellpadding="0" cellspacing="0" class="" style="width:660px;" width="660"><tr><td style="line-height:0;font-size:0;mso-line-height-rule:exactly;">
<![endif]-->
    <div style="margin:0px auto;max-width:660px;">
      <table align="center" border="0" cellpadding="0" cellspacing="0" style="width:100%;">
        <tbody>
          <tr>
            <td style="direction:ltr;font-size:0;padding:0;text-align:center;">
              <!--[if mso | IE]>
<table border="0" cellpadding="0" cellspacing="0"><tr><td class="" style="vertical-align:top;width:660px;">
<![endif]-->
              <div class="pc100 ogf"
                style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                  <tbody>
                    <tr>
                      <td style="vertical-align:top;padding:0;">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                          <tbody>
                            <tr>
                              <td align="center" class="i fw-1 " style="font-size:0;padding:0;word-break:break-word;">
                                <table border="0" cellpadding="0" cellspacing="0"
                                  style="border-collapse:collapse;border-spacing:0;" class="fwm">
                                  <tbody>
                                    <tr>
                                      <td style="width:660px;" class="fwm"> <img alt="" height="auto"
                                          src="https://f002.backblazeb2.com/file/emailify/dcb459e9f207cb7458224829186d30e9.jpg"
                                          style="border:0;display:block;outline:none;text-decoration:none;height:auto;width:100%;font-size:13px;"
                                          width="660">
                                      </td>
                                    </tr>
                                  </tbody>
                                </table>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!--[if mso | IE]>
</td></tr></table>
<![endif]-->
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <!--[if mso | IE]>
</td></tr></table>
<table align="center" border="0" cellpadding="0" cellspacing="0" class="r-outlook -outlook pr-16-outlook pl-16-outlook -outlook" style="width:660px;" width="660" bgcolor="#fffffe"><tr><td style="line-height:0;font-size:0;mso-line-height-rule:exactly;">
<![endif]-->
    <div class="r pr-16 pl-16 "
      style="background:#fffffe;background-color:#fffffe;margin:0px auto;border-radius:0;max-width:660px;">
      <table align="center" border="0" cellpadding="0" cellspacing="0"
        style="background:#fffffe;background-color:#fffffe;width:100%;border-radius:0;">
        <tbody>
          <tr>
            <td style="border:none;direction:ltr;font-size:0;padding:0px 30px 24px 30px;text-align:center;">
              <!--[if mso | IE]>
<table border="0" cellpadding="0" cellspacing="0"><tr><td class="c-outlook -outlook -outlook" style="vertical-align:top;width:600px;">
<![endif]-->
              <div class="xc600 ogf c "
                style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:100%;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                  <tbody>
                    <tr>
                      <td
                        style="background-color:transparent;border:none;vertical-align:top;padding:38px 0px 38px 0px;">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                          <tbody>
                            <tr>
                              <td align="center" class="i fw-1 hm-1 m"
                                style="font-size:0;padding:0;padding-bottom:37px;word-break:break-word;">
                                <table border="0" cellpadding="0" cellspacing="0"
                                  style="border-collapse:collapse;border-spacing:0;" class="fwm">
                                  <tbody>
                                    <tr>
                                      <td style="width:190px;" class="fwm"> <img alt="" height="auto"
                                          src="https://f002.backblazeb2.com/file/emailify/8289c7fc551219afbc9934e5a65a1f7c.png"
                                          style="border:0;border-radius:0;display:block;outline:none;text-decoration:none;height:auto;width:100%;font-size:13px;"
                                          width="190">
                                      </td>
                                    </tr>
                                  </tbody>
                                </table>
                              </td>
                            </tr>
                            <tr>
                              <td align="center" class="i w-75 hd-1 m"
                                style="mso-hide:all;display:none;height:0;overflow:hidden;font-size:0;padding:0;padding-bottom:37px;word-break:break-word;">
                                <table border="0" cellpadding="0" cellspacing="0"
                                  style="mso-hide:all;border-collapse:collapse;border-spacing:0;">
                                  <tbody style="mso-hide:all;">
                                    <tr style="mso-hide:all;">
                                      <td style="mso-hide:all;width:75px;" width="75"> <img alt="" height="auto"
                                          src="https://f002.backblazeb2.com/file/emailify/e9aa6642cfc7a0427ce3b7dc9da81641.png"
                                          style="mso-hide:all;border:0;border-radius:0;display:block;outline:none;text-decoration:none;height:auto;width:100%;font-size:13px;"
                                          width="75">
                                      </td>
                                    </tr>
                                  </tbody>
                                </table>
                              </td>
                            </tr>
                            <tr>
                              <td align="center" class="x fs-13 lh-14 m"
                                style="font-size:0;padding:0;padding-bottom:37px;word-break:break-word;">
                                <div
                                  style="font-family:Montserrat,Arial,sans-serif;font-size:20px;line-height:24px;text-align:center;color:#000000;">
                                  <p style="Margin:0;text-align:center;"><span
                                      style="mso-line-height-rule:exactly;font-size:20px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:24px;">Olá
                                      {{name}}, </span></p>
                                  <p style="Margin:0;"><span
                                      style="mso-line-height-rule:exactly;font-size:20px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:24px;">&nbsp;</span>
                                  </p>
                                  <p style="Margin:0;"><span
                                      style="mso-line-height-rule:exactly;font-size:20px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:24px;">Obrigado
                                      por se cadastrar em nosso aplicativo, </span></p>
                                  <p style="Margin:0;"><span
                                      style="mso-line-height-rule:exactly;font-size:20px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:24px;">falta
                                      pouco agora! </span></p>
                                  <p style="Margin:0;"><span
                                      style="mso-line-height-rule:exactly;font-size:20px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:24px;">&nbsp;</span>
                                  </p>
                                  <p style="Margin:0;"><span
                                      style="mso-line-height-rule:exactly;font-size:20px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:24px;">Para
                                      validarmos seu ao aplicativo com segurança, </span></p>
                                  <p style="Margin:0;"><span
                                      style="mso-line-height-rule:exactly;font-size:20px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:24px;">insira
                                      o código abaixo em nosso aplicativo:</span></p>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td class="r pt-0 pr-0 pb-0 pl-0 m"
                                style="font-size:0;padding:5px 13px 5px 13px;padding-bottom:37px;word-break:break-word;">
                                <!--[if mso | IE]>
<table align="center" border="0" cellpadding="0" cellspacing="0" class="r-outlook -outlook pt-0-outlook pr-0-outlook pb-0-outlook pl-0-outlook m-outlook" style="width:600px;" width="600" bgcolor="#fffffe"><tr><td style="line-height:0;font-size:0;mso-line-height-rule:exactly;">
<![endif]-->
                                <div class="r pt-0 pr-0 pb-0 pl-0 m"
                                  style="background:#fffffe;background-color:#fffffe;margin:0px auto;border-radius:12px 12px 12px 12px;max-width:600px;">
                                  <table align="center" border="0" cellpadding="0" cellspacing="0"
                                    style="background:#fffffe;background-color:#fffffe;width:100%;border-radius:12px 12px 12px 12px;">
                                    <tbody>
                                      <tr>
                                        <td
                                          style="border:3px solid #00ddc2;direction:ltr;font-size:0;padding:5px 13px 5px 13px;text-align:justify;">
                                          <!--[if mso | IE]>
<table border="0" cellpadding="0" cellspacing="0"><tr><td class="" style="width:568px;">
<![endif]-->
                                          <div class="pc100 ogf"
                                            style="font-size:0;line-height:0;text-align:left;display:inline-block;width:100%;direction:ltr;">
                                            <!--[if mso | IE]>
<table border="0" cellpadding="0" cellspacing="0"><tr><td style="vertical-align:middle;width:138px;">
<![endif]-->
                                            <div class="pc24-404761904761905 ogf m c "
                                              style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:24.404761904761905%;">
                                              <table border="0" cellpadding="0" cellspacing="0"
                                                style="background-color:transparent;border:none;vertical-align:middle;"
                                                width="100%">
                                                <tbody>
                                                  <tr>
                                                    <td align="center" class="x "
                                                      style="font-size:0;padding:0;padding-bottom:0;word-break:break-word;">
                                                      <div
                                                        style="font-family:Montserrat,Arial,sans-serif;font-size:36px;line-height:44px;text-align:center;color:#000000;">
                                                        <p style="Margin:0;text-align:center;"><span
                                                            style="mso-line-height-rule:exactly;font-size:36px;font-family:Montserrat,Arial,sans-serif;font-weight:600;color:#3c3c3c;line-height:44px;">{{first}}</span>
                                                        </p>
                                                      </div>
                                                    </td>
                                                  </tr>
                                                </tbody>
                                              </table>
                                            </div>
                                            <!--[if mso | IE]>
</td><td style="vertical-align:top;width:3px;">
<![endif]-->
                                            <div class="pc0-6613754090808687 ogf g"
                                              style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:0.6613754090808687%;">
                                              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                <tbody>
                                                  <tr>
                                                    <td style="vertical-align:top;padding:0;">
                                                      <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                        <tbody></tbody>
                                                      </table>
                                                    </td>
                                                  </tr>
                                                </tbody>
                                              </table>
                                            </div>
                                            <!--[if mso | IE]>
</td><td style="vertical-align:middle;width:138px;">
<![endif]-->
                                            <div class="pc24-404761904761905 ogf m c "
                                              style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:24.404761904761905%;">
                                              <table border="0" cellpadding="0" cellspacing="0"
                                                style="background-color:transparent;border:none;vertical-align:middle;"
                                                width="100%">
                                                <tbody>
                                                  <tr>
                                                    <td align="center" class="x "
                                                      style="font-size:0;padding:0;padding-bottom:0;word-break:break-word;">
                                                      <div
                                                        style="font-family:Montserrat,Arial,sans-serif;font-size:36px;line-height:44px;text-align:center;color:#000000;">
                                                        <p style="Margin:0;text-align:center;"><span
                                                            style="mso-line-height-rule:exactly;font-size:36px;font-family:Montserrat,Arial,sans-serif;font-weight:600;color:#3c3c3c;line-height:44px;">{{second}}</span>
                                                        </p>
                                                      </div>
                                                    </td>
                                                  </tr>
                                                </tbody>
                                              </table>
                                            </div>
                                            <!--[if mso | IE]>
</td><td style="vertical-align:top;width:3px;">
<![endif]-->
                                            <div class="pc0-6613754090808687 ogf g"
                                              style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:0.6613754090808687%;">
                                              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                <tbody>
                                                  <tr>
                                                    <td style="vertical-align:top;padding:0;">
                                                      <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                        <tbody></tbody>
                                                      </table>
                                                    </td>
                                                  </tr>
                                                </tbody>
                                              </table>
                                            </div>
                                            <!--[if mso | IE]>
</td><td style="vertical-align:middle;width:138px;">
<![endif]-->
                                            <div class="pc24-404761904761905 ogf m c "
                                              style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:24.404761904761905%;">
                                              <table border="0" cellpadding="0" cellspacing="0"
                                                style="background-color:transparent;border:none;vertical-align:middle;"
                                                width="100%">
                                                <tbody>
                                                  <tr>
                                                    <td align="center" class="x "
                                                      style="font-size:0;padding:0;padding-bottom:0;word-break:break-word;">
                                                      <div
                                                        style="font-family:Montserrat,Arial,sans-serif;font-size:36px;line-height:44px;text-align:center;color:#000000;">
                                                        <p style="Margin:0;text-align:center;"><span
                                                            style="mso-line-height-rule:exactly;font-size:36px;font-family:Montserrat,Arial,sans-serif;font-weight:600;color:#3c3c3c;line-height:44px;">{{third}}</span>
                                                        </p>
                                                      </div>
                                                    </td>
                                                  </tr>
                                                </tbody>
                                              </table>
                                            </div>
                                            <!--[if mso | IE]>
</td><td style="vertical-align:top;width:3px;">
<![endif]-->
                                            <div class="pc0-6613754090808687 ogf g"
                                              style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:0.6613754090808687%;">
                                              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                <tbody>
                                                  <tr>
                                                    <td style="vertical-align:top;padding:0;">
                                                      <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                        <tbody></tbody>
                                                      </table>
                                                    </td>
                                                  </tr>
                                                </tbody>
                                              </table>
                                            </div>
                                            <!--[if mso | IE]>
</td><td style="vertical-align:middle;width:138px;">
<![endif]-->
                                            <div class="pc24-404761904761905 ogf c "
                                              style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:24.404761904761905%;">
                                              <table border="0" cellpadding="0" cellspacing="0"
                                                style="background-color:transparent;border:none;vertical-align:middle;"
                                                width="100%">
                                                <tbody>
                                                  <tr>
                                                    <td align="center" class="x "
                                                      style="font-size:0;padding:0;padding-bottom:0;word-break:break-word;">
                                                      <div
                                                        style="font-family:Montserrat,Arial,sans-serif;font-size:36px;line-height:44px;text-align:center;color:#000000;">
                                                        <p style="Margin:0;text-align:center;"><span
                                                            style="mso-line-height-rule:exactly;font-size:36px;font-family:Montserrat,Arial,sans-serif;font-weight:600;color:#3c3c3c;line-height:44px;">{{fourth}}</span>
                                                        </p>
                                                      </div>
                                                    </td>
                                                  </tr>
                                                </tbody>
                                              </table>
                                            </div>
                                            <!--[if mso | IE]>
</td><td style="vertical-align:top;width:3px;">
<![endif]-->
                                            <div class="pc0-5952380952380952 ogf"
                                              style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:top;width:0.5952380952380952%;">
                                              <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                <tbody>
                                                  <tr>
                                                    <td style="vertical-align:top;padding:0;">
                                                      <table border="0" cellpadding="0" cellspacing="0" width="100%">
                                                        <tbody></tbody>
                                                      </table>
                                                    </td>
                                                  </tr>
                                                </tbody>
                                              </table>
                                            </div>
                                            <!--[if mso | IE]>
</td></tr></table>
<![endif]-->
                                          </div>
                                          <!--[if mso | IE]>
</td></tr></table>
<![endif]-->
                                        </td>
                                      </tr>
                                    </tbody>
                                  </table>
                                </div>
                                <!--[if mso | IE]>
</td></tr></table>
<![endif]-->
                              </td>
                            </tr>
                            <tr>
                              <td align="center" class="x fs-13 m"
                                style="font-size:0;padding:0;padding-bottom:37px;word-break:break-word;">
                                <div
                                  style="font-family:Montserrat,Arial,sans-serif;font-size:16px;line-height:20px;text-align:center;color:#000000;">
                                  <p style="Margin:0;text-align:center;"><span
                                      style="mso-line-height-rule:exactly;font-size:16px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:20px;">Estamos
                                      ansiosos para ter você em nosso </span><span
                                      style="mso-line-height-rule:exactly;font-size:16px;font-family:Montserrat,Arial,sans-serif;font-weight:700;color:#3c3c3c;line-height:20px;">IZI
                                      TEAM</span><span
                                      style="mso-line-height-rule:exactly;font-size:16px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:20px;">!
                                      😍</span></p>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td align="center" class="x m"
                                style="font-size:0;padding:0;padding-bottom:37px;word-break:break-word;">
                                <div
                                  style="font-family:Montserrat,Arial,sans-serif;font-size:15px;line-height:18px;text-align:center;color:#000000;">
                                  <p style="Margin:0;text-align:center;"><span
                                      style="mso-line-height-rule:exactly;font-size:15px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:18px;">Equipe</span><span
                                      style="mso-line-height-rule:exactly;font-size:15px;font-family:Montserrat,Arial,sans-serif;font-weight:800;color:#3c3c3c;line-height:18px;">
                                      IZI.FIT</span></p>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td align="center" class="x fs-13 m"
                                style="font-size:0;padding:0px 116px 0px 116px;padding-bottom:37px;word-break:break-word;">
                                <div
                                  style="font-family:Montserrat,Arial,sans-serif;font-size:15px;line-height:18px;text-align:center;color:#000000;">
                                  <p style="Margin:0;text-align:center;"><span
                                      style="mso-line-height-rule:exactly;font-size:15px;font-family:Montserrat,Arial,sans-serif;font-weight:500;color:#3c3c3c;line-height:18px;">Contato:
                                      {{business.phone}} | {{business.email}} </span></p>
                                </div>
                              </td>
                            </tr>
                            <tr>
                              <td class="s " style="font-size:0;padding:0;padding-bottom:0;word-break:break-word;">
                                <div style="height:4px;line-height:4px;">&#8202;</div>
                              </td>
                            </tr>
                          </tbody>
                        </table>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!--[if mso | IE]>
</td></tr></table>
<![endif]-->
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <!--[if mso | IE]>
</td></tr></table>
<table align="center" border="0" cellpadding="0" cellspacing="0" class="r-outlook -outlook pr-16-outlook pl-16-outlook hd-1-outlook -outlook" style="width:660px;" width="660" bgcolor="#3c3c3c"><tr><td style="line-height:0;font-size:0;mso-line-height-rule:exactly;">
<![endif]-->
    <div class="r pr-16 pl-16 hd-1 "
      style="mso-hide:all;display:none;height:0;overflow:hidden;background:#3c3c3c;background-color:#3c3c3c;margin:0px auto;border-radius:0;max-width:660px;">
      <table align="center" border="0" cellpadding="0" cellspacing="0"
        style="mso-hide:all;background:#3c3c3c;background-color:#3c3c3c;width:100%;border-radius:0;" width="100%"
        bgcolor="#3c3c3c">
        <tbody style="mso-hide:all;">
          <tr style="mso-hide:all;">
            <td
              style="mso-hide:all;border:none;direction:ltr;font-size:0;padding:16px 16px 16px 62px;text-align:center;"
              align="center">
              <!--[if mso | IE]>
<table border="0" cellpadding="0" cellspacing="0"><tr><td class="c-outlook -outlook -outlook" style="vertical-align:middle;width:582px;">
<![endif]-->
              <div class="xc582 ogf c "
                style="mso-hide:all;font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:100%;">
                <table border="0" cellpadding="0" cellspacing="0"
                  style="mso-hide:all;background-color:transparent;border:none;vertical-align:middle;" width="100%"
                  bgcolor="transparent" valign="middle">
                  <tbody style="mso-hide:all;">
                    <tr style="mso-hide:all;">
                      <td align="left" class="x m"
                        style="mso-hide:all;font-size:0;padding:0px 239px 0px 0px;padding-bottom:7px;word-break:break-word;">
                        <div
                          style="mso-hide:all;font-family:Montserrat,Arial,sans-serif;font-size:11px;line-height:13px;text-align:left;color:#000000;">
                          <p style="mso-hide:all;Margin:0;text-align:left;"><span
                              style="mso-hide:all;mso-line-height-rule:exactly;font-size:11px;font-family:Montserrat,Arial,sans-serif;font-weight:700;color:#ffffff;line-height:13px;">Perguntas?</span>
                          </p>
                        </div>
                      </td>
                    </tr>
                    <tr style="mso-hide:all;">
                      <td align="left" class="x "
                        style="mso-hide:all;font-size:0;padding:0;padding-bottom:0;word-break:break-word;">
                        <div
                          style="mso-hide:all;font-family:Montserrat,Arial,sans-serif;font-size:10px;line-height:12px;text-align:left;color:#000000;">
                          <p style="mso-hide:all;Margin:0;text-align:left;"><span
                              style="mso-hide:all;mso-line-height-rule:exactly;font-size:10px;font-family:Montserrat,Arial,sans-serif;font-weight:400;color:#ffffff;line-height:12px;">Nós
                              estamos aqui para ajudar, </span></p>
                          <p style="mso-hide:all;Margin:0;"><span
                              style="mso-hide:all;mso-line-height-rule:exactly;font-size:10px;font-family:Montserrat,Arial,sans-serif;font-weight:400;color:#ffffff;line-height:12px;">contate-nos.</span>
                          </p>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <!--[if mso | IE]>
</td></tr></table>
<![endif]-->
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <!--[if mso | IE]>
</td></tr></table>
<table align="center" border="0" cellpadding="0" cellspacing="0" class="r-outlook -outlook pr-16-outlook pl-16-outlook hm-1-outlook -outlook" style="width:660px;" width="660" bgcolor="#3c3c3c"><tr><td style="line-height:0;font-size:0;mso-line-height-rule:exactly;">
<![endif]-->
    <div class="r pr-16 pl-16 hm-1 "
      style="background:#3c3c3c;background-color:#3c3c3c;margin:0px auto;border-radius:0;max-width:660px;">
      <table align="center" border="0" cellpadding="0" cellspacing="0"
        style="background:#3c3c3c;background-color:#3c3c3c;width:100%;border-radius:0;">
        <tbody>
          <tr>
            <td style="border:none;direction:ltr;font-size:0;padding:16px 16px 16px 16px;text-align:center;">
              <!--[if mso | IE]>
<table border="0" cellpadding="0" cellspacing="0"><tr><td class="" style="width:628px;">
<![endif]-->
              <div class="pc100 ogf"
                style="font-size:0;line-height:0;text-align:left;display:inline-block;width:100%;direction:ltr;">
                <!--[if mso | IE]>
<table border="0" cellpadding="0" cellspacing="0"><tr><td style="vertical-align:middle;width:628px;">
<![endif]-->
                <div class="pc100 ogf c "
                  style="font-size:0;text-align:left;direction:ltr;display:inline-block;vertical-align:middle;width:100%;">
                  <table border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td
                          style="background-color:transparent;border:none;vertical-align:middle;padding:0px 100px 0px 100px;">
                          <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tbody>
                              <tr>
                                <td align="left" class="x m"
                                  style="font-size:0;padding:0;padding-bottom:7px;word-break:break-word;">
                                  <div
                                    style="font-family:Montserrat,Arial,sans-serif;font-size:18px;line-height:22px;text-align:left;color:#000000;">
                                    <p style="Margin:0;text-align:left;"><span
                                        style="mso-line-height-rule:exactly;font-size:18px;font-family:Montserrat,Arial,sans-serif;font-weight:700;color:#ffffff;line-height:22px;">Perguntas?</span>
                                    </p>
                                  </div>
                                </td>
                              </tr>
                              <tr>
                                <td align="left" class="x "
                                  style="font-size:0;padding:0;padding-bottom:0;word-break:break-word;">
                                  <div
                                    style="font-family:Montserrat,Arial,sans-serif;font-size:16px;line-height:20px;text-align:left;color:#000000;">
                                    <p style="Margin:0;text-align:left;"><span
                                        style="mso-line-height-rule:exactly;font-size:16px;font-family:Montserrat,Arial,sans-serif;font-weight:400;color:#ffffff;line-height:20px;">Nós
                                        estamos aqui para ajudar, contate-nos.</span></p>
                                  </div>
                                </td>
                              </tr>
                            </tbody>
                          </table>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <!--[if mso | IE]>
</td></tr></table>
<![endif]-->
              </div>
              <!--[if mso | IE]>
</td></tr></table>
<![endif]-->
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <!--[if mso | IE]>
</td></tr></table>
<![endif]-->
  </div>
</body>

</html>
        """;

        var content = Map.of(
            "name", "Renato",
            "first", "9",
            "second", "6",
            "third", "8",
            "fourth", "2",
            "business", Map.of(
                "phone", "+55 011 99999-9999",
                "email", "loremipsum@izi.fit"
            )
        );
                
        return Mustache.compiler().compile(template).execute(content);
    }
}
