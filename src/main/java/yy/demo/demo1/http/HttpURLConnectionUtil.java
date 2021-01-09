package yy.demo.demo1.http;


import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author riemann
 * @date 2019/05/24 23:42
 */
@Data
public class HttpURLConnectionUtil{

	/**
	 * Http get请求
	 * @param httpUrl 连接
	 * @return 响应数据
	 */
	public static String doGet(String httpUrl){
		//链接
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		StringBuffer result = new StringBuffer();
		try {
			//创建连接
			URL url = new URL(httpUrl);
			connection = (HttpURLConnection) url.openConnection();
			//设置请求方式
			connection.setRequestMethod("GET");
			//设置连接超时时间
			connection.setReadTimeout(15000);
			//开始连接
			connection.connect();
			//获取响应数据
			if (connection.getResponseCode() == 200) {
				//获取返回的数据
				is = connection.getInputStream();
				if (null != is) {
					br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
					String temp = null;
					while (null != (temp = br.readLine())) {
						result.append(temp);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//关闭远程连接
			connection.disconnect();
		}
		return result.toString();
	}

	/**
	 * Http post请求
	 * @param httpUrl 连接
	 * @param param 参数
	 * @return
	 */
	public static String doPost(String httpUrl, String param) {
		StringBuffer result = new StringBuffer();
		//连接
		HttpURLConnection connection = null;
		OutputStream os = null;
		InputStream is = null;
		BufferedReader br = null;
		try {
			//创建连接对象
			URL url = new URL(httpUrl);
			//创建连接
			connection = (HttpURLConnection) url.openConnection();
			//设置请求方法
			connection.setRequestMethod("POST");
			//设置连接超时时间
			connection.setConnectTimeout(15000);
			//设置读取超时时间
			connection.setReadTimeout(15000);
			//DoOutput设置是否向httpUrlConnection输出，DoInput设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
			//设置是否可读取
			connection.setDoOutput(true);
			connection.setDoInput(true);
			//设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			connection.setRequestProperty("Content-Type", "application/json;charset=utf-8");

			//拼装参数
			if (null != param && param.equals("")) {
				//设置参数
				os = connection.getOutputStream();
				//拼装参数
				os.write(param.getBytes("UTF-8"));
			}
			//设置权限
			//设置请求头等
			//开启连接
			//connection.connect();
			//读取响应
			if (connection.getResponseCode() == 200) {
				is = connection.getInputStream();
				if (null != is) {
					br = new BufferedReader(new InputStreamReader(is, "GBK"));
					String temp = null;
					while (null != (temp = br.readLine())) {
						result.append(temp);
						result.append("\r\n");
					}
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//关闭连接
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//关闭连接
			connection.disconnect();
		}
		return result.toString();
	}

	public static void main(String[] args) {


		int count =10000;

		List<String> urls = Lists.newArrayList();
		urls.add("https://wenku.baidu.com/view/c670ac0a2a4ac850ad02de80d4d8d15abf230033?channel=newindex");
		urls.add("https://wenku.baidu.com/view/8362f8be5d0e7cd184254b35eefdc8d377ee144d?channel=newindex");
		urls.add("https://wenku.baidu.com/view/9eb0780d7d1cfad6195f312b3169a4517623e505?channel=newindex");

		urls.add("https://wenku.baidu.com/view/7871aa500042a8956bec0975f46527d3250ca657?channel=newindex");
		urls.add("https://wenku.baidu.com/view/f5ed28e758eef8c75fbfc77da26925c52dc591d8?channel=newindex");
		urls.add("https://wenku.baidu.com/view/3d8045810722192e4436f63b?channel=newindex");
		urls.add("https://wenku.baidu.com/view/de74855c294ac850ad02de80d4d8d15abf2300e1?channel=newindex");
		urls.add("https://wenku.baidu.com/view/98b047d8a617866fb84ae45c3b3567ec112ddc1b?channel=newindex");
		urls.add("https://wenku.baidu.com/view/f5ed28e758eef8c75fbfc77da26925c52dc591d8?channel=newindex");
		urls.add("https://wenku.baidu.com/view/e09bf6097d1cfad6195f312b3169a4517623e522?channel=newindex");
		urls.add("https://wenku.baidu.com/view/28b23d98935f804d2b160b4e767f5acfa0c78370?channel=newindex");
		urls.add("https://wenku.baidu.com/view/eb8e7bbabf1e650e52ea551810a6f524cdbfcbd6?channel=newindex");

		// 棉
		urls.add("https://wenku.baidu.com/view/5597c29b793e0912a21614791711cc7930b778ec?channel=newindex");
		urls.add("https://wenku.baidu.com/view/46875266340cba1aa8114431b90d6c85ed3a88fb?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a14f6d7fe43a580216fc700abb68a98270feac00?channel=newindex");
		urls.add("https://wenku.baidu.com/view/8692c528c0c708a1284ac850ad02de80d5d806a2?channel=newindex");
		urls.add("https://wenku.baidu.com/view/95bb22915b0102020740be1e650e52ea5418ce7a?channel=newindex");
		urls.add("https://wenku.baidu.com/view/46875266340cba1aa8114431b90d6c85ed3a88fb?channel=newindex");
		urls.add("https://wenku.baidu.com/view/ff0debf1f02d2af90242a8956bec0975f565a4a2?channel=newindex");


		urls.add("https://wenku.baidu.com/view/3d8045810722192e4436f63b");
		urls.add("https://wenku.baidu.com/view/1f67c262d838376baf1ffc4ffe4733687e21fce4");
		urls.add("https://wenku.baidu.com/view/309b5b4c9989680203d8ce2f0066f5335a8167fc?channel=newindex");
		urls.add("https://wenku.baidu.com/view/f104967b03d276a20029bd64783e0912a3167c60?channel=newindex");
		urls.add("https://wenku.baidu.com/view/b80faf9cdcccda38376baf1ffc4ffe473268fd78?channel=newindex");
		urls.add("https://wenku.baidu.com/view/fde340bc16791711cc7931b765ce0508773275cd?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a3dc207a03d276a20029bd64783e0912a3167cbb?channel=newindex");
		urls.add("https://wenku.baidu.com/view/fbdad110112de2bd960590c69ec3d5bbfc0adabd?channel=newindex");
		urls.add("https://wenku.baidu.com/view/2668a317940590c69ec3d5bbfd0a79563c1ed4be?channel=newindex");
		urls.add("https://wenku.baidu.com/view/9df30901c9d376eeaeaad1f34693daef5ff71392?channel=newindex");
		urls.add("https://wenku.baidu.com/view/3cbd619c4973f242336c1eb91a37f111f0850d25?channel=newindex");
		urls.add("https://wenku.baidu.com/view/b8b85384bb0d6c85ec3a87c24028915f814d840f?channel=newindex");
		urls.add("https://wenku.baidu.com/view/23979e03710abb68a98271fe910ef12d2bf9a9c4?channel=newindex");


		urls.add("https://wenku.baidu.com/view/0214ad8f5527a5e9856a561252d380eb63942359?channel=newindex");
		urls.add("https://wenku.baidu.com/view/57f70e1867ce0508763231126edb6f1afe00716c?channel=newindex");
		urls.add("https://wenku.baidu.com/view/1717dbea54270722192e453610661ed9ac51555e?channel=newindex");
		urls.add("https://wenku.baidu.com/view/73b9382e32d4b14e852458fb770bf78a64293a7f?channel=newindex");
		urls.add("https://wenku.baidu.com/view/fce5ffe52379168884868762caaedd3382c4b568?channel=newindex");
		urls.add("https://wenku.baidu.com/view/1772e916e109581b6bd97f19227916888586b963?channel=newindex");
		urls.add("https://wenku.baidu.com/view/b964f6835bcfa1c7aa00b52acfc789eb162d9e76?channel=newindex");
		urls.add("https://wenku.baidu.com/view/0280427a82d049649b6648d7c1c708a1294a0ac0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/74d11fdd031ca300a6c30c22590102020640f2c9?channel=newindex");
		urls.add("https://wenku.baidu.com/view/9340f9bc5a1b6bd97f192279168884868662b831?channel=newindex");
		urls.add("https://wenku.baidu.com/view/8969bc83094c2e3f5727a5e9856a561253d3217a?channel=newindex");
		urls.add("https://wenku.baidu.com/view/83d1e4eabc1e650e52ea551810a6f524cdbfcb2f?channel=newindex");
		urls.add("https://wenku.baidu.com/view/d7e017f902d8ce2f0066f5335a8102d277a26135?channel=newindex");
		urls.add("https://wenku.baidu.com/view/3f8e86efa31614791711cc7931b765ce04087afc?channel=newindex");


		urls.add("https://wenku.baidu.com/view/1d6da19e41323968011ca300a6c30c225801f01b?channel=newindex");
		urls.add("https://wenku.baidu.com/view/553f56735222aaea998fcc22bcd126fff6055d6f?channel=newindex");
		urls.add("https://wenku.baidu.com/view/dede5f98ec06eff9aef8941ea76e58fafab04596?channel=newindex");
		urls.add("https://wenku.baidu.com/view/448ac325d05abe23482fb4daa58da0116d171f56?channel=newindex");
		urls.add("https://wenku.baidu.com/view/068cf944e209581b6bd97f19227916888586b92b?channel=newindex");
		urls.add("https://wenku.baidu.com/view/e4b630f26d85ec3a87c24028915f804d2a1687d6?channel=newindex");
		urls.add("https://wenku.baidu.com/view/acc35f9949d7c1c708a1284ac850ad02df8007f6?channel=newindex");
		urls.add("https://wenku.baidu.com/view/4066ddbfb968a98271fe910ef12d2af90342a801?channel=newindex");
		urls.add("https://wenku.baidu.com/view/1d514851dc3383c4bb4cf7ec4afe04a1b171b062?channel=newindex");
		urls.add("https://wenku.baidu.com/view/3f8e86efa31614791711cc7931b765ce04087afc?channel=newindex");


		urls.add("https://wenku.baidu.com/view/8c427162d838376baf1ffc4ffe4733687e21fc80?channel=newindex");
		urls.add("https://wenku.baidu.com/view/8c427162d838376baf1ffc4ffe4733687e21fc80?channel=newindex");
		urls.add("https://wenku.baidu.com/view/9c333e29b8f3f90f76c66137ee06eff9aff8497e?channel=newindex");
		urls.add("https://wenku.baidu.com/view/9c333e29b8f3f90f76c66137ee06eff9aff8497e?channel=newindex");
		urls.add("https://wenku.baidu.com/view/6b01a7db8c9951e79b89680203d8ce2f0166654e?channel=newindex");
		urls.add("https://wenku.baidu.com/view/6b01a7db8c9951e79b89680203d8ce2f0166654e?channel=newindex");
		urls.add("https://wenku.baidu.com/view/b3bdcbe2fc4733687e21af45b307e87100f6f81e?channel=newindex");
		urls.add("https://wenku.baidu.com/view/b3bdcbe2fc4733687e21af45b307e87100f6f81e?channel=newindex");
		urls.add("https://wenku.baidu.com/view/12b7d9ce091c59eef8c75fbfc77da26924c59616?channel=newindex");
		urls.add("https://wenku.baidu.com/view/12b7d9ce091c59eef8c75fbfc77da26924c59616?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/ab149b2e29ea81c758f5f61fb7360b4c2f3f2ada?channel=newindex");
		urls.add("https://wenku.baidu.com/view/9f37f63a6037ee06eff9aef8941ea76e59fa4a65?channel=newindex");
		urls.add("https://wenku.baidu.com/view/c373212586868762caaedd3383c4bb4cf7ecb7e9?channel=newindex");

		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a072e8bbff0a79563c1ec5da50e2524de518d0e0?channel=newindex");






		test(urls,count);

	}
	public static void test(List<String> urls,Integer count){
		urls.forEach(url ->{
			ThreadPools.exec.execute(() -> {
				for (int i = 0; i <count; i++) {
					String s = doGet(url);
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" ："+i);

				}
			});

		});
	}

	void test002(){
		List<String> urls = Lists.newArrayList();
		urls.add("https://wenku.baidu.com/view/5597c29b793e0912a21614791711cc7930b778ec?channel=newindex");
		urls.add("https://wenku.baidu.com/view/46875266340cba1aa8114431b90d6c85ed3a88fb?channel=newindex");
		urls.add("https://wenku.baidu.com/view/a14f6d7fe43a580216fc700abb68a98270feac00?channel=newindex");
		urls.add("https://wenku.baidu.com/view/8692c528c0c708a1284ac850ad02de80d5d806a2?channel=newindex");
		urls.add("https://wenku.baidu.com/view/95bb22915b0102020740be1e650e52ea5418ce7a?channel=newindex");
		urls.add("https://wenku.baidu.com/view/46875266340cba1aa8114431b90d6c85ed3a88fb?channel=newindex");
		urls.add("https://wenku.baidu.com/view/ff0debf1f02d2af90242a8956bec0975f565a4a2?channel=newindex");
		urls.add("https://wenku.baidu.com/view/ce6232fea7c30c22590102020740be1e640ecc2c?channel=newindex");
		urls.add("https://wenku.baidu.com/view/ce6232fea7c30c22590102020740be1e640ecc2c?channel=newindex");
		urls.add("https://wenku.baidu.com/view/ce6232fea7c30c22590102020740be1e640ecc2c?channel=newindex");

	}


}

