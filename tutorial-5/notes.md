## Entity

````
Mahasiswa

NPM: String (Primary Key)
Nama : String
Email: String
ipk: String
noTelp: String
mataKuliahID :String (ManyToOne)
logs : []Log (OneToMany)

MataKuliah

KodeMatkul: String (Primary Key)
namaMatkul: String
prodi: String
Mahasiswa : []Mahasiswa (OneToMany)

Log

idLog: integer(Primary Key, auto increment)
start: datetime
end: datetime
Deskripsi: Text
````

## Response Class
```
LaporanPembayaran

month : String
jamKerja : int
pembayaran : int
```



## API Call

GET /mahasiswa
-------------
* Response
````
[
    {
        "npm": "String",
        "nama": "String",
        "email": "String",
        "ipk": "String",
        "noTelp": "String",
        "logs": [],
        "mataKuliahID": null
    }
]
````

POST /mahasiswa
----------
* Request Body
```
{
    "npm": "String",
    "nama": "String",
    "email": "String",
    "ipk": "String",
    "noTelp": "String"
    
}

```
* Response
```
{
    "npm": "String",
    "nama": "String",
    "email": "String",
    "ipk": "String",
    "noTelp": "String"
    "logs": null,
    "mataKuliahID": null
}

```

GET /mahasiswa/{npm}
-------------
* Response
````

{
    "npm": "String",
    "nama": "String",
    "email": "String",
    "ipk": "String",
    "noTelp": "String",
    "logs": [],
    "mataKuliahID": null
}

````

PUT /mahasiswa/{npm}
----------
* Request Body
```
{
    "npm": "String",
    "nama": "String",
    "email": "String",
    "ipk": "String",
    "noTelp": "String"
    
}

```
* Response
```
{
    "npm": "String",
    "nama": "String",
    "email": "String",
    "ipk": "String",
    "noTelp": "String"
    "logs": null,
    "mataKuliahID": null
}

```

DELETE /mahasiswa/{npm}
----------

* Response
```

```


POST /mahasiswa/{npm}
----------
* Request Body
```
{
    idLog: "String"
    start: datetime
    end: datetime
    Deskripsi: "String"
    
}

```
* Response
```
{
    "npm": "String",
    "nama": "String",
    "email": "String",
    "ipk": "String",
    "noTelp": "String"
    "logs": [
        {
            idLog: "String"
            start: datetime
            end: datetime
            Deskripsi: "String"
        }
    ],
    "mataKuliahID": null
}

```

PUT /mahasiswa/{npm}/{logID}
----------
* Request Body
```
{
    idLog: "String"
    start: datetime
    end: datetime
    Deskripsi: "String"
    
}

```
* Response
```
{
    "npm": "String",
    "nama": "String",
    "email": "String",
    "ipk": "String",
    "noTelp": "String"
    "logs": [
        {
            idLog: "String"
            start: datetime
            end: datetime
            Deskripsi: "String"
        }
    ],
    "mataKuliahID": null
}

```

DELETE /mahasiswa/{npm}/{logID}
----------
* Response
```

```

GET /mahasiswa/laporan-pembayaran/{npm}
----------
* Response
```aidl
[
    {
        month : String
        jamKerja : int
        pembayaran : int
    }

]
```


GET /mata-kuliah/
----------
* Response
```aidl
[
    {
        KodeMatkul: String
        namaMatkul: String
        prodi: String
        Mahasiswa : []Mahasiswa
    }

]
```

POST /mata-kuliah/
----------
* Request
```aidl

{
    KodeMatkul: String
    namaMatkul: String
    prodi: String
    Mahasiswa : []Mahasiswa
}


```

* Response
```aidl
{
    KodeMatkul: String
    namaMatkul: String
    prodi: String
    Mahasiswa : []Mahasiswa
}
```

GET /mata-kuliah/{kodeMatkul}
----------

* Response
```aidl
{
    KodeMatkul: String
    namaMatkul: String
    prodi: String
    Mahasiswa : []Mahasiswa
}
```

PUT /mata-kuliah/{kodeMatkul}
----------
* Request
```aidl

{
    nama: String
    prodi: String
}


```

* Response
```aidl
{
    KodeMatkul: String
    nama: String
    prodi: String
    Mahasiswa : []Mahasiswa
}
```

DELETE /mata-kuliah/{kodeMatkul}
----------

* Response
```aidl

```

POST /mata-kuliah/asdos/{kodeMatkul}
----------
* Request
```aidl

{
    npm : "string"
}


```

* Response
```aidl
{
    "kodeMatkul": "String",
    "nama": "String",
    "prodi": "String",
    "asdos": [
        {
            "npm": "String",
            "nama": "String",
            "email": "String,
            "ipk": "String",
            "noTelp": "String",
            "logs": [],
            "mataKuliahID": "String"
        }
    ]
}
```
