@hepsiburadaLoginCaseleri
Feature: Login Caseleri

  Background: Login Sayfasina Gitme
    Given kullanici login sayfasina gider

  @usernameButonlariniDogrulama
  Scenario: Username Buton ve Text Kutularini Dogrulama
    Given kullanici username sayfasındaki buton ve text kutularini dogrular

  @gecerliEpostaIleGiris
  Scenario: Gecerli Username Ile Giris Yapma
    Given kullanici username metin kutusuna "gecerli_username" girer
    Then kullanici hosgeldiniz yazisi aldigini dogrular

  @gecerliTelIleGiris
  Scenario: Gecerli Tel Numarasi Ile Giris Yapma
    Given kullanici username metin kutusuna "gecerli_tel" girer
    Then kullanici hosgeldiniz yazisi aldigini dogrular

  @gecersizMailsizGiris
  Scenario: Gecersiz Metin Girmeden Giris Yapma
    Given kullanici username metin kutusuna "" girer
    Then kullanici mail veya tel girmelisiniz yazisi aldigini dogrular

  @gecersizMailIleGiris
  Scenario Outline: Gecersiz Metin Girmeden Giris Yapma
    Given kullanici username metin kutusuna "<gecersiz_mail>" girer
    Then kullanici gecerli posta girmelisiniz yazisi aldigini dogrular
    Examples:
      | gecersiz_mail        |
      | xxxxx                |
      | xxxxx@mail.c         |
      | xxxxx@mail           |
      | xxxxx@mail.commmmmmm |
      | @mail.com            |

  @gecersizTelIleGiris
  Scenario Outline: Gecersiz Metin Girmeden Giris Yapma
    Given kullanici username metin kutusuna "<gecersiz_tel>" girer
    Then kullanici gecerli telefon girmelisiniz yazisi aldigini dogrular
    Examples:
      | gecersiz_tel    |
      | 1               |
      | 05555555        |
      | 055555555555555 |
      | 04444444444     |

  @gecersizHesapOlmayanMailGiris
  Scenario: Gecersiz Hesabi Olmayan Mail Giris Yapma
    Given kullanici username metin kutusuna "hesabı_olmayan_mail" girer
    Then kullanici gecersiz veya eksik mail yazisi aldigini dogrular


  @passwordButonlariniDogrulama
  Scenario: Username Buton ve Text Kutularini Dogrulama
    Given kullanici username metin kutusuna "gecerli_username" girer
    Then kullanici password sayfasındaki buton ve text kutularini dogrular

  @gecerliPasswordGiris
  Scenario: Gecerli Password Ile Giris Yapma
    Given kullanici username metin kutusuna "gecerli_username" girer
    And kullanici password metin kutusuna "gecerli_password" girer
    Then kullanici giris yapabildigini anasayfadan dogrular

  @gecersizSifresizGiris
  Scenario: Gecersiz Metin Girmeden Giris Yapma
    Given kullanici username metin kutusuna "gecerli_username" girer
    And kullanici password metin kutusuna "" girer
    Then kullanici sifrenizi girmelisiniz yazisi aldigini dogrular

  @gecersizSifreIleGiris
  Scenario Outline: Gecersiz Metin Girmeden Giris Yapma
    Given kullanici username metin kutusuna "gecerli_username" girer
    And kullanici username metin kutusuna "<gecersiz_sifre>" girer
    Then kullanici sifre eksik veya hatali yazisi aldigini dogrular
    Examples:
      | gecersiz_sifre |
      | xxxxx          |
      | 123456         |
      | 5              |
      | abcdef         |
