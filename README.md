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
            app:rounded_background_color="@color/red"
            app:show_guidelines="false"
            app:overflow_prefix="+"
            />
```


## Personal opinion

PS: I think that some  bits in the original Chris' post are not correct (at least in my case) so I decided to build this prototype with small tweaks and fixes.

## Licence



