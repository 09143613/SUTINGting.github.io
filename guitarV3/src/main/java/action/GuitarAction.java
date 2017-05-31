package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.DataAccess;
import dao.IGuitar;
import model.Builder;
import model.Guitar;
import model.GuitarSpec;
import model.Inventory;
import model.Type;
import model.Wood;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.GuitarService;
import service.GuitarServiceImpl;


public class GuitarAction extends ActionSupport {
		
	public  String searchGuitar() throws Exception{
		out();
		
		JSONArray array=new JSONArray();
		
		IGuitar guitarDao=DataAccess.createGuitarDao();
		GuitarService guitarService=new GuitarServiceImpl();		
		guitarService.setGuitarDao(guitarDao);
		Inventory inventory=new Inventory(guitarService.getGuitar());
		GuitarSpec guitarSpec=new GuitarSpec(builder,model,type,backWood,topWood,numStrings);
		List<Guitar> macthingGuitars=inventory.search(guitarSpec);	
		
		for(Guitar g:macthingGuitars){
			 JSONObject jo=new JSONObject();
			 
			 jo.put("serialNumber",g.getSerialNumber());
			 jo.put("price",g.getPrice());
			 jo.put("builder",g.getSpec().getBuilder());
			 jo.put("model",g.getSpec().getModel());
			 jo.put("type",g.getSpec().getType());
			 jo.put("backWood",g.getSpec().getBackWood());
			 jo.put("topWood",g.getSpec().getTopWood());
			 jo.put("numStrings",g.getSpec().getNumStrings());
			 array.add(jo);
		}
		out().print(array);
		out().flush(); 
		out().close();
		return SUCCESS;
	}
	
	//输出字段
	public PrintWriter out() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();  
        response.setContentType("text/html");  
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter out= response.getWriter();
        return out;
	}
	
	//添加
	public String addGuitar() throws Exception{
		//out();
		//String tip="";
		IGuitar guitarDao=DataAccess.createGuitarDao();
		GuitarService guitarService=new GuitarServiceImpl();		
		guitarService.setGuitarDao(guitarDao);
		GuitarSpec guitarSpec=new GuitarSpec(builder, model, type, backWood,
				topWood,numStrings);
		Guitar guitar=new Guitar(serialNumber,price,guitarSpec);
		jsonObject.put("status", "ok");
		try{
			guitar.setSerialNumber(serialNumber);
			guitar.setPrice(price);
			
			guitarSpec.setBuider(builder);
			guitarSpec.setType(type);
			guitarSpec.setModel(model);
			guitarSpec.setBackWood(backWood);
			guitarSpec.setTopWood(topWood);
			guitarSpec.setNumStrings(numStrings);
			
			guitar.setGuitarSpec(guitarSpec);
			
			guitarService.addGuitar(guitar);
			//tip="添加成功";
		}
		catch(Exception e){
			jsonObject.put("status", "nook");
		}
		return "jsonObject";
		
	}
	GuitarService guitarService = new GuitarServiceImpl();
	//删除
	public String delGuitar() throws Exception{
		IGuitar guitarDao=DataAccess.createGuitarDao();
		GuitarService guitarService=new GuitarServiceImpl();	
		guitarService.setGuitarDao(guitarDao);
		try{
			guitarService.delGuitar(serialNumber);
		}catch(Exception e){
			jsonObject.put("status", "nook");
		}
		jsonObject.put("status", "ok");
		return "jsonObject";
	}
		
	private JSONArray jsonArray = new JSONArray();
	
	public JSONArray getJsonArray() {
		return jsonArray;
	}
	
	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}
	
	private JSONObject jsonObject=new JSONObject();
	
	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

		/*  */
		private Builder builder; 
		private String model;
		private Type type;
		private Wood backWood;
		private Wood topWood;
		private int numStrings;
		private double price;
		private String serialNumber;
		
		
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getSerialNumber() {
			return serialNumber;
		}

		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}

		public int getNumStrings() {
			return numStrings;
		}

		public void setNumStrings(int numStrings) {
			this.numStrings = numStrings;
		}

		public Builder getBuilder() {
			return builder;
		}
		public void setBuilder(Builder builder) {
			this.builder = builder;
		}
		public String getModel() {
			return model;
		}
		public void setModel(String model) {
			this.model = model;
		}
		public Type getType() {
			return type;
		}
		public void setType(Type type) {
			this.type = type;
		}
		public Wood getBackWood() {
			return backWood;
		}
		public void setBackWood(Wood backWood) {
			this.backWood = backWood;
		}
		public Wood getTopWood() {
			return topWood;
		}
		public void setTopWood(Wood topWood) {
			this.topWood = topWood;
		}
		
}
