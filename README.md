##PasswordDialogView

该控件是一个放支付宝和微信支付的在支付时输入密码框的控件，也是笔者在项目开发中遇到了同样需求，就将其封装了出来

效果图如下

![image](https://github.com/Fizzzzer/Android_Fizzer_PasswordDialogView/blob/master/screenShot/test.gif)

只需要简单的一句话就可以调用该效果，

	public void Test(View view){
       new PassWordDialog(this).setTitle("请输入交易密码")
               .setSubTitle("到账金额(元)")
               .setMoney("100.00").setCompleteListener(new DialogCompleteListener() {
            @Override
            public void dialogCompleteListener(String money, String pwd) {
                Toast.makeText(MainActivity.this,"金额=" + money + "密码=" + pwd,Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
    

关于各个参数的解释图如下

![参数解释图](https://github.com/Fizzzzer/Android_Fizzer_PasswordDialogView/blob/master/screenShot/screenshot.png)


最后，能力有限，还有不足的地方欢迎大家指出，一起学习进步
