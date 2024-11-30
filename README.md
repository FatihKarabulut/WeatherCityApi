WeatherCityApi, hava durumu ve şehir bilgisi döndüren bir mikro servis projesidir.

Proje şu şekilde çalışmaktadır:
1. Hava Durumu Sorgulama: Kullanıcı tarafından girilen şehir bilgisi doğrultusunda, önce Geonames API'den şehir bilgisi elde edilir.
   Alınan verilerden enlem (latitude) ve boylam (longitude) koordinatları alınarak, bu koordinatlar kullanılarak ilgili şehrin hava durumu bilgisi tekrar Geonames API'den sorgulanır.

2. Şehir Bilgisi Sorgulama: Eğer kullanıcı yalnızca şehir bilgisini almak isterse, Geonames API'den şehir bilgisi alınır ve bu bilgiler bir liste olarak döndürülür.


