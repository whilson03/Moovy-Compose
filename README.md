# Moovy-Compose
Moovy is a simple Jetpack Compose project built using [The Movie DB](https://www.themoviedb.org) based on Kotlin MVVM architecture.
<br>

<div class="row">
<img src="screens/home.png" height="800" alt="screenshot"/>
<img src="https://user-images.githubusercontent.com/34584911/123158851-25e97c00-d421-11eb-853a-a81c6730ea42.gif" height="800" alt="screenshot"/>
 </div>




## How to build on your environment
Clone your repository and open it in the latest [Android Studio (Canary build)](https://developer.android.com/studio/preview).

Add your [The Movie DB](https://www.themoviedb.org)'s API key in your `local.properties` file.

```
tmdb_api_key=YOUR_API_KEY
```

## Tech stack & Open-source libraries
- Dagger Hilt
- Paging-Compose
- Minimum SDK level 21
- [Retrofit2 & Gson](https://github.com/square/retrofit) - constructing the REST API
- [OkHttp3](https://github.com/square/okhttp) - implementing interceptor, logging.
- [Timber](https://github.com/JakeWharton/timber) - logging



```

MIT License

Copyright (c) 2021 Adeyoriju Olabode

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
