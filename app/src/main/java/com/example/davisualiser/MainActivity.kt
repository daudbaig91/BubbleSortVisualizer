package com.example.davisualiser

import android.R.attr.data
import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LayoutAnimationController
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


//color #C8C8C8
class MainActivity : AppCompatActivity() {

    lateinit var swapAnimation:BubbleSortTranslate
    val listBubbleSort: MutableList<BubbleSortDataAnimation> = ArrayList()
    lateinit var arr:IntArray
    lateinit var arrx:IntArray
    lateinit var savedview:View

    var speed:Long = 500
    var distance:Float = 0.toFloat();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedview = findViewById(R.id.BubbleSort)
        val button = findViewById<ImageView>(R.id.button)
        val textspeed = findViewById<TextView>(R.id.textspeed)
        val simpleSeekBar=findViewById<SeekBar>(R.id.seekBar2)
        val backbttn=findViewById<ImageView>(R.id.backbttn)




        simpleSeekBar.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                speed= 1000 - (((simpleSeekBar.progress).toDouble()/4+0.50)*500).toLong()

                swapAnimation = SwapAnimation().SwapAnimation(speed,distance)

                textspeed.text = ((simpleSeekBar.progress).toDouble()/4+0.50).toString() + "x"
            }
        })


        button.setOnClickListener {

            topbardisplay()
        }

    }
    var playing:Boolean = false

    fun player(view: View) {
        val image = view as ImageView
        if (playing) {

            image.setImageResource(android.R.drawable.ic_media_play)
            playing = false
            cancela = false
            bubblesortdisplayanimation(x,"")

        } else {
            playing = true
            image.setImageResource(android.R.drawable.ic_media_pause)
            cancelattion()
            cancela = true
        }

    }
    fun back(view: View){
        cancelattion()
        if(x>0) {
            println(x)
            x--
            println(x)
            bbubblesortdisplayanimationback(x, "next")
        }
    }

    //cncllation func

    fun cancelattion(){
        swapAnimation.translateAnimation.cancel()
        swapAnimation.translateAnimation2.cancel()

    }
    fun next(view: View){
        if(x <= listBubbleSort.size)
            println(x)
            cancelattion()
            bubblesortdisplayanimation(x,"next")
    }

    var booleanresetend = true
    var waitSpeeed: Long = 300


    fun resetnext(view: View){
        x=listBubbleSort.size-1
        arr = arr.sortedArray()
        GraphCreator(arr,false)
        x=listBubbleSort.size-1
        println(x)
    }



    fun resetback(view: View) {
        GraphCreator(arrx,true)
        x= 0
    }

    fun createSorthide(view: View){
        val r1sorted = findViewById<RelativeLayout>(R.id.sortedshow)
        val r2unsorted = findViewById<RelativeLayout>(R.id.unsortedshow)

        if(resources.getResourceEntryName(view.id) == "Nearlysortedbttn"){
            r2unsorted.visibility = View.INVISIBLE
            r1sorted.visibility = View.VISIBLE

        }else if(resources.getResourceEntryName(view.id) == "Sortedbttn"){
            r1sorted.visibility = View.INVISIBLE
            r2unsorted.visibility = View.VISIBLE
        }
    }
    fun tstlo(view: View){
        val r1sorted = findViewById<TextView>(R.id.Sortedbttn)
        r1sorted.text = "s"
    }

    fun topbardisplay(){  //create class
        val hidelay = findViewById<LinearLayout>(R.id.hidelayout)
        val params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        val fragsize = findViewById<LinearLayout>(R.id.l2)
        val param2 = fragsize.layoutParams
        val button = findViewById<ImageView>(R.id.button)
         if(hidelay.visibility == View.VISIBLE){
            button.animate().apply {
                duration = 400
                rotationX(0f)
            }.start()
            fragsize.layoutParams = param2
             hidelay.visibility  = View.GONE
        }else{
            button.animate().apply {
                duration = 400
                rotationX(180f)
            }.start()
            fragsize.layoutParams = params
             hidelay.visibility  = View.VISIBLE
        }
    }

    fun buttnselect(view: View) {
        replaceView(view)
    }

    fun replaceView(view: View){

         var curTitle = findViewById<TextView>(R.id.titletopbar)

         var x = view as TextView

         (savedview as TextView).visibility = View.VISIBLE
         curTitle.text  = x.text
         savedview = view
         view.visibility = View.GONE
        topbardisplay()

     }
    var ls = 0
    fun hideSort(view: View){
        val rotateima1 = findViewById<ImageView>(R.id.menubttnpic)
        val rotateima2 = findViewById<ImageView>(R.id.menubttn3)
        val extendCreate = findViewById<RelativeLayout>(R.id.creatorext)

        val id = resources.getResourceEntryName(view.id)
        val AnimationR = AnimationRotateimage()


        if(id == "codelinearlayout" || id == "codebttn" ){
            val hidesorts = findViewById<LinearLayout>(R.id.explaintext)
            hidesorts.visibility = if (hidesorts.visibility == View.GONE){
                View.VISIBLE


            }else{
                View.GONE
            }
        }
        else if( id == "explainLinearLayout" || id == "menubttn3"){
            val hidesorts = findViewById<TextView>(R.id.explaintext2)

            hidesorts.visibility = if (hidesorts.visibility == View.GONE){
                AnimationR.rotateY(rotateima2,2)

                View.VISIBLE
            }else{

                AnimationR.rotateY(rotateima2,1)
                View.GONE
            }

        }
        else{
            val hidesorts = findViewById<RelativeLayout>(R.id.menutiems)

            hidesorts.visibility = if (hidesorts.visibility == View.GONE){
                AnimationR.rotateY(rotateima1,1)
                extendCreate.visibility = View.VISIBLE
                View.VISIBLE


            }else{
                AnimationR.rotateY(rotateima1,2)
                extendCreate.visibility = View.GONE
                View.GONE
            }
        }
    }
    fun sort(view: View) {
        val Create = findViewById<RelativeLayout>(R.id.creator)
        val Create2 = findViewById<ImageView>(R.id.menubttn3)
        val Create3 = findViewById<TextView>(R.id.codebttn)
        hideSort(Create)
        hideSort(Create2)
        hideSort(Create3)


        val graphs = findViewById<LinearLayout>(R.id.graphslinearlayout)
        distance = SwapAnimation().dist(graphs.getChildAt(0) as RelativeLayout,   graphs.getChildAt(1) as RelativeLayout,applicationContext)

        swapAnimation = SwapAnimation().SwapAnimation(speed,distance)
        bubbleSort(arr)

        bubblesortdisplayanimation(0,"")

/*        val graphs = findViewById<LinearLayout>(R.id.graphslinearlayout)
        swapAnimation = SwapAnimation().SwapAnimation(graphs.getChildAt(0) as RelativeLayout,
            graphs.getChildAt(1) as RelativeLayout,this)
        graphs.getChildAt(
            5).startAnimation(swapAnimation.translateAnimation)
        graphs.getChildAt(6).startAnimation(swapAnimation.translateAnimation2)*/
    }

    var x :Int = 0
    var animationrunning = false
    var cancela = false

    @TargetApi(Build.VERSION_CODES.N)
    fun bbubblesortdisplayanimationback(index:Int, str:String){
        x = index
        val progressbar = findViewById<ProgressBar>(R.id.progressBar2)
        progressbar.setProgress(2,true)
        Thread(Runnable{
            val graphs = findViewById<LinearLayout>(R.id.graphslinearlayout)


            val bubbleSortDataAnimation: BubbleSortDataAnimation = listBubbleSort.get(x)
            val lineartemp: RelativeLayout =
                graphs.getChildAt(bubbleSortDataAnimation.x1) as RelativeLayout
            val linear1: RelativeLayout =
                graphs.getChildAt(bubbleSortDataAnimation.x2) as RelativeLayout
            lineartemp.getChildAt(0)
                .setBackgroundColor(Color.parseColor("#aab2ff"))
            linear1.getChildAt(0)
                .setBackgroundColor(Color.parseColor("#aab2ff"))

            if (bubbleSortDataAnimation.change == true) {

                lineartemp.startAnimation(swapAnimation.translateAnimation)
                linear1.startAnimation(swapAnimation.translateAnimation2)
                swapAnimation.translateAnimation.setAnimationListener(object :
                    Animation.AnimationListener {
                    override fun onAnimationStart(a: Animation) {}
                    override fun onAnimationRepeat(a: Animation) {}
                    override fun onAnimationEnd(a: Animation) {

                        swapAnimation.translateAnimation.cancel()
                        swapAnimation.translateAnimation2.cancel()
                        lineartemp.clearAnimation()
                        linear1.clearAnimation()
                        //Modify The Views to be swapped
                        graphs.removeView(linear1)
                        graphs.addView(linear1, bubbleSortDataAnimation.x1)

                        graphs.removeView(lineartemp)
                        graphs.addView(lineartemp, bubbleSortDataAnimation.x2)


                        //remove the current element from list, to be to next step
                        //For future to modify to new data structure to undo button


                        //change background back to original color
                        linear1.getChildAt(0)
                            .setBackgroundColor(Color.parseColor("#80FFDB"))
                        lineartemp.getChildAt(0)
                            .setBackgroundColor(Color.parseColor("#80FFDB"))
                        //wait 5 sec
                        Thread.sleep(waitSpeeed)


                    }
                })
            }
        }).start()
    }
    val backgroundColor:BackgroundColor = BackgroundColor()
    @TargetApi(Build.VERSION_CODES.N)
    fun bubblesortdisplayanimation(index:Int, str:String){
        x = index
        val progressbar = findViewById<ProgressBar>(R.id.progressBar2)
        progressbar.max = listBubbleSort.size-1
        progressbar.setProgress(x,true)
        val exptext = findViewById<LinearLayout>(R.id.explaintext)
        val exptext1 = findViewById<TextView>(R.id.explaintext2)
        val graphs = findViewById<LinearLayout>(R.id.graphslinearlayout)
        //get first element from list

        val bubbleSortDataAnimation: BubbleSortDataAnimation = listBubbleSort.get(x)

        val lineartemp: RelativeLayout =
            graphs.getChildAt(bubbleSortDataAnimation.x1) as RelativeLayout
        val linear1: RelativeLayout =
            graphs.getChildAt(bubbleSortDataAnimation.x2) as RelativeLayout



        exptext1.text = ("Checking if " +( lineartemp.getChildAt(1) as TextView).text
                + " > " +( linear1.getChildAt(1) as TextView).text) + " nd swap them if that is true; swapped = true."


        backgroundColor.backgroundChanger(exptext,2)

        Thread.sleep(waitSpeeed)

        Thread(Runnable {



            //saving both elements to be/not swapped

            //error here....


                //selecting View from both Rl Views
                lineartemp.getChildAt(0)
                    .setBackgroundColor(Color.parseColor("#aab2ff"))
                linear1.getChildAt(0)
                    .setBackgroundColor(Color.parseColor("#aab2ff"))


                //New Thread

                //if Swap Animation+change has to happen
                if (bubbleSortDataAnimation.change == true) {

                    //start swapping aniamtions
                   val codeSource:CodeSource = CodeSource()
                    runOnUiThread {
                        exptext1.text = ("Swapping the positions of " +( lineartemp.getChildAt(1) as TextView).text
                        + " and " +( linear1.getChildAt(1) as TextView).text) + " and set swapped = true. For inversion index: Add 1 to swapCounter, now = 39."
                        backgroundColor.backgroundChanger(exptext,3)
                    }


                    lineartemp.startAnimation(swapAnimation.translateAnimation)
                    linear1.startAnimation(swapAnimation.translateAnimation2)

                    //listen for aniamtion end to jump to next animation
                    swapAnimation.translateAnimation.setAnimationListener(object :
                        Animation.AnimationListener {
                        override fun onAnimationStart(a: Animation) {}
                        override fun onAnimationRepeat(a: Animation) {}
                        override fun onAnimationEnd(a: Animation) {

                            swapAnimation.translateAnimation.cancel()
                            swapAnimation.translateAnimation2.cancel()
                            lineartemp.clearAnimation()
                            linear1.clearAnimation()
                            //Modify The Views to be swapped
                            graphs.removeView(linear1)
                            graphs.addView(linear1, bubbleSortDataAnimation.x1)

                            graphs.removeView(lineartemp)
                            graphs.addView(lineartemp, bubbleSortDataAnimation.x2)

                            //remove the current element from list, to be to next step
                            //For future to modify to new data structure to undo button


                            //change background back to original color
                            linear1.getChildAt(0)
                                .setBackgroundColor(Color.parseColor("#80FFDB"))
                            lineartemp.getChildAt(0)
                                .setBackgroundColor(Color.parseColor("#80FFDB"))
                            //wait 5 sec
                            if(bubbleSortDataAnimation.colour){
                                lineartemp.getChildAt(0)
                                    .setBackgroundColor(Color.parseColor("#ffae89"))
                            }
                            Thread.sleep(waitSpeeed)
                            //if next steps in list or NotEmpty

                            if (x < listBubbleSort.size-1 ) {
                                x++
                                if (cancela != true)
                                    bubblesortdisplayanimation(x,"")
                            }
                        }
                    })

                    //else if change not be made
                } else {
                    //remove current step from list
                    Thread.sleep(waitSpeeed)
                    swapAnimation.translateAnimation.cancel()
                    swapAnimation.translateAnimation2.cancel()
                    lineartemp.clearAnimation()
                    linear1.clearAnimation()

                    linear1.getChildAt(0)
                        .setBackgroundColor(Color.parseColor("#80FFDB"))
                    lineartemp.getChildAt(0)
                        .setBackgroundColor(Color.parseColor("#80FFDB"))
                    if(bubbleSortDataAnimation.colour){
                        linear1.getChildAt(0)
                            .setBackgroundColor(Color.parseColor("#ffae89"))
                    }
                    Thread.sleep(waitSpeeed)


                    if (x < listBubbleSort.size-1) {
                        //reset to original colour
                        //if list has mroe steps call fucntion agai
                        x++
                        if (cancela != true)
                       bubblesortdisplayanimation(x,"")
                    }

                }

            }).start()
    }

    fun bubbleSort(arr:IntArray):IntArray{
        var swap = true
        listBubbleSort.clear()
        var x = 1
        var c = 0
        var i = 0
        while(swap){

            swap = false
            i=0
            while(i < arr.size-x){
                if(arr[i] > arr[i+1]){
                    if(arr.size-x-1 == i) {
                        listBubbleSort.add(BubbleSortDataAnimation(i, i + 1, true, true))
                    }else{
                        listBubbleSort.add(BubbleSortDataAnimation(i, i + 1, true, false))
                    }
                    val temp = arr[i]
                    arr[i] = arr[i+1]
                    arr[i + 1] = temp
                    println(arr.contentToString())
                    //dsnt substract minimum loop
                    swap = true
                    c++
                }else{
                    if(arr.size-1-x == i) {
                        listBubbleSort.add(BubbleSortDataAnimation(i, i + 1, false, true))
                    }else{
                        listBubbleSort.add(BubbleSortDataAnimation(i, i + 1, false, false))
                    }
                    c++
                }
                i++
            }
            x++
        }


        return arr
    }


    fun graphfunction(view: View):Int{

        if(resources.getResourceEntryName(view.id)=="randombttn" ||
            resources.getResourceEntryName(view.id)=="viewcreate"){
            arr = ArrGenerator().Randomarr()
        }else if(resources.getResourceEntryName(view.id)=="randomtextbttn"){
            var text : String = findViewById<EditText>(R.id.customtext).text.toString()
            text = SpaceRemover().SpaceRemover(text)
            try {
                arr = text.split(",").map { it.toInt() }.toIntArray()
            }catch (exception :Exception){
                text = text.replace(",","")
                if(text.contains(" ")) {
                    Toast.makeText(
                        applicationContext, "Please Remove Spaces.",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else if(!text.matches("[0-9]+".toRegex())){

                    Toast.makeText(
                        applicationContext, "Please enter Digits Only.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        applicationContext, "Wrong input type. Try Again",
                        Toast.LENGTH_LONG
                    ).show()
                }
                return 1
            }
        }
        else if(resources.getResourceEntryName(view.id)=="increasingbttn"){
            arr = ArrGenerator().SortedAsc()
        }else if(resources.getResourceEntryName(view.id)=="decreasingbttn"){
            arr = ArrGenerator().Sorteddesc()
        }else if(resources.getResourceEntryName(view.id)=="unincreasingbttn"){
            arr = ArrGenerator().nearlySortedAsc()
        }else if(resources.getResourceEntryName(view.id)=="undecreasingbttn"){
            arr = ArrGenerator().nearlySorteddesc()
        }
        arrx = arr
        GraphCreator(arr,true)

        return 1
    }

    fun GraphCreator(arr :IntArray,boolean: Boolean){
        val graphs = findViewById<LinearLayout>(R.id.graphslinearlayout)
        graphs.removeAllViews()
        var height = graphs.height


        for (i in arr.indices){

            val viewText = TextView(this)

            //view.id = R.id.textviewnumber
            //error due to this piece fo code, was changing views id number and was removing
            //buttons textviews, error being displayed was referenece was null, as no id exited due to
            //changeof ids to textviewnumber

            val viewtextparams = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            viewText.gravity = Gravity.CENTER
            viewText.layoutParams = viewtextparams
            viewtextparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
            viewtextparams.setMargins(0,0 ,dpToPx((20).toFloat(),this),0)

            val RLayout = RelativeLayout(this)
            RLayout.gravity = Gravity.CENTER_VERTICAL

            val paramsRelativeLayout = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            paramsRelativeLayout.weight = 1f
            RLayout.layoutParams = paramsRelativeLayout


            height -= viewText.height
            val view1 = View(this)

            val xx = height - (height.toDouble()*(arr[i].toDouble()/100.00))

            viewText.text = (arr[i]).toString()
            viewText.setTextColor(Color.BLACK)


            val params = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )



            params.setMargins(0,xx.toInt() ,dpToPx((20).toFloat(),this),0)
            params.addRule(RelativeLayout.ABOVE,R.id.textviewnumber)
            params.layoutAnimationParameters = LayoutAnimationController.AnimationParameters()
            view1.layoutParams = params

            if(boolean)
                view1.setBackgroundColor(Color.parseColor("#80FFDB"))
            else
                view1.setBackgroundColor(Color.parseColor("#ffae89"))
            RLayout.addView(view1)
            RLayout.addView(viewText)
            graphs.addView(RLayout)
        }
    }
    fun dpToPx(dp: Float, context: Context): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.getResources().getDisplayMetrics()
        ).toInt()
    }
}