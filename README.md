# MyTest
尝试
简单的画板view
实现了画线，改变颜色，橡皮，撤销，改变线宽，清屏功能

![示意图](https://github.com/GOGJIAN/MyTest/blob/master/Screenshot_1524567882.png)

添加依赖：
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  dependencies {
	        compile 'com.github.GOGJIAN:MyTest:v1.3'
	}
  
使用：
<com.jianjian.android.opensourcelibrary.DrawPlaneView
        android:id="@+id/draw_plane_view"/>
        
private DrawPlaneView dpv;
dpv = (DrawPlaneView)findViewById(R.id.draw_plane_view);
       

       
