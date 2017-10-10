# RecyclerViewInRecyclerView
RecyclerView嵌套RecyclerView滑动冲突

这样一个界面：
顶部为Tablayout，下面关联ViewPager,ViewPager里面是Fragment界面，里面有个水平布局的RecyclerView。
滑动水平RecyclerView时很不流畅，经常触发外部RecyclerView的滚动事件。
解决：
重写外部的RecyclerView：判断水平滑动x>y时候不拦截事件，这样滑动水平RecyclerView
就不会触发外部的RecyclerView。

http://blog.csdn.net/ww96054993/article/details/73822812
