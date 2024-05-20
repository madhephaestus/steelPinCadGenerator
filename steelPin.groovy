import eu.mihosoft.vrl.v3d.parametrics.*;
import java.util.stream.Collectors;
import com.neuronrobotics.bowlerstudio.vitamins.Vitamins;
import eu.mihosoft.vrl.v3d.CSG;
import eu.mihosoft.vrl.v3d.Cube;
CSG generate(){
	String type= "steelPin"
	if(args==null)
		args=["2x10mm"]
	// The variable that stores the current size of this vitamin
	StringParameter size = new StringParameter(	type+" Default",args.get(0),Vitamins.listVitaminSizes(type))
	HashMap<String,Object> measurments = Vitamins.getConfiguration( type,size.getStrValue())

	def MaxFreeSpeedRadPerSecValue = measurments.MaxFreeSpeedRadPerSec
	def MaxTorqueNewtonmetersValue = measurments.MaxTorqueNewtonmeters
	def massCentroidXValue = measurments.massCentroidX
	def massCentroidYValue = measurments.massCentroidY
	def massCentroidZValue = measurments.massCentroidZ
	def massKgValue = measurments.massKg
	def pinDiameterValue = measurments.pinDiameter
	def pinLengthValue = measurments.pinLength
	def priceValue = measurments.price
	def shaftSizeValue = measurments.shaftSize
	def shaftTypeValue = measurments.shaftType
	def sourceValue = measurments.source
	for(String key:measurments.keySet().stream().sorted().collect(Collectors.toList())){
		println "steelPin value "+key+" "+measurments.get(key);
}
	// Stub of a CAD object
	CSG part = new Cube().toCSG()
	return part
		.setParameter(size)
		.setRegenerate({generate()})
}
return generate() 