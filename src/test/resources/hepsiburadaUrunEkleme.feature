@hepsiburadaUrunEkleme
Feature: Sepete Urun Ekleme

  Background: Siteye Giris
    Given kullanici hepsiburadayi ziyaret eder


  @girisYapmadanUrunEkleme
  Scenario: Kullanici Girisi Yapilmadan Urun Ekleme
    Given kullanici "duracell pil" urun aramasi yapar
    And kullanici almak istedigi urunu secer
    And kullanici urunu iki farkli saticidan sepete ekler
    Then kullanici sectigi urunleri sepetten dogrular


  @girisYaparakUrunEkleme
  Scenario: Kullanici Girisi Yapilarak Urun Ekleme
    Given kullanici giris yapar
    And kullanici giris yapabildigini anasayfadan dogrular
    And kullanici "bridgestone t005" urun aramasi yapar
    And kullanici almak istedigi urunu secer
    And kullanici urunu iki farkli saticidan sepete ekler
    Then kullanici sectigi urunleri sepetten dogrular
