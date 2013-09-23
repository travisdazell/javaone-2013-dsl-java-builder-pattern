package net.travisdazell.javaone;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TeeTime {

	static class CreateTeeTime {

		private Golfer golfer;
		private Date time;

		public CreateTeeTime() {
		}
		
		public CreateTeeTime setFirstName(String firstName) {
			golfer = new Golfer();
			golfer.setFirstName(firstName);
			
			return this;
		}
		
		public CreateTeeTime setLastName(String lastName) {
			golfer.setLastName(lastName);
			
			return this;
		}
		
		public CreateTeeTime setNumberOfGuests(int numberOfGuests) {
			golfer.setNumberOfGuests(numberOfGuests);

			return this;
		}
		
		public TeeTime setTime(String time) {
			DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy hh:mm a");
			try {
				this.time = (Date) (formatter.parse(time));
			} catch (ParseException e) {
				System.err.println(e.getMessage());
			}

			return new TeeTime(this);
		}
	}

	@SuppressWarnings("unused")
	@XmlElement
	private Golfer golfer;

	@SuppressWarnings("unused")
	@XmlElement
	private Date time;
	
	public TeeTime() {
		// this is intentionally left blank for JAXB
	}

	private TeeTime(CreateTeeTime b) {
		this.time = b.time;
		this.golfer = b.golfer;
	}

	public String bookTeeTime() {
		String result = new String();
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TeeTime.class);
			
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(this, sw);
			
			result = sw.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
