# CounterTextView
This is a POC of a 'perfectly' centered text in android....(where 'gravity' is not enough).
Part of this code is based on a Chris Banes's blog post (https://chris.banes.me/2014/03/27/measuring-text/).

## Discaimer
The *traditional* way of centering text and rounded it's layout can be achieved playing with *gravity and rounded shape as backgound*. If this approach works for you, cool! just use it ;)

If on the other end you want a self-centering text view feel free to have a look here.
I have prepared a ```CenteredTextView``` with Chris's raccomandations and a ```CounterTextView``` with a couple of convenient methods for specific usage as counter.

## Demo

![Demo effect with notification](/../screenshots/screenshots/counterDemo03.gif?raw=true "Example with a notification counter") 

## Usage
Insert in your layout:
```java
 <org.fpezzato.countertextview.CounterTextView
            android:id="@+id/counter_text_view"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="@android:color/white"
            android:textSize="12sp"
            app:ctv_rounded_background_color="@color/red"
            app:ctv_show_guidelines="false"
            app:ctv_overflow_prefix="+"
            />
```

Custom attributes you can specify:
* ```ctv_rounded_background_color```:  a reference to a valid color used as 'holo' with rounded corners. If the text is short enough, a perfect circle shape is kept, based on the current text size. whoo!
* ```ctv_show_guidelines```: true/false, to display a visual reference grid with debug pourpose. 
* ```ctv_overflow_prefix```: The string prefixed to the max upper bound when the count overflow the limit.


## Personal opinion

PS: Some bits in the original Chris Banes post were not working in my case so I have build this prototype with tiny tweaks and fixes.

License
-------

The MIT License (MIT)

Copyright (c) 2015 Francesco

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

