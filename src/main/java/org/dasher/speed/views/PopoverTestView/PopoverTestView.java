package org.dasher.speed.views.PopoverTestView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.dom.Style.FlexDirection;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.dasher.speed.base.ui.component.PopoverTooltip;


@PageTitle( "PopoverTestView / Summary" )
@Menu( order = 0, icon = "vaadin:clipboard-check", title = RouteConfig.GENERAL_ISSUE_NAME )
@Route( RouteConfig.GENERAL_ISSUE_PATH )
public class PopoverTestView extends Main {
	
	private class MySpan extends Span {
		
		public MySpan( String text ) {
			super( text );
			getStyle().setMaxWidth( "800px" );
			getStyle().setMarginBottom( "1rem" );
		}
		
	}
	
	public PopoverTestView() {
		add( new H2( RouteConfig.GENERAL_ISSUE_NAME ) );
		
		add( new MySpan( "For certain components the popover implementation of the tooltip doesn't work as expected. Hover the date picker down below for an example." ) );
		add( new MySpan( "Problem 1: The Popover remains open when the date picker is opened." ) );
		add( new MySpan( "Problem 2: The Popover remains open when the date picker is closed by click outside." ) );
		Span datePickerContainer = new Span();
		datePickerContainer.getStyle().setMaxWidth( "200px" );
		DatePicker datePicker = new DatePicker();
		PopoverTooltip.createOrRenew( datePicker, "<span>Select a <b>date</b></span>" );
		datePickerContainer.add( datePicker );
		add( datePickerContainer );
		addClassNames( LumoUtility.BoxSizing.BORDER, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.COLUMN, LumoUtility.Padding.MEDIUM, LumoUtility.Gap.SMALL );
		
		Div testButtonContainer = new Div();
		testButtonContainer.getStyle().setFlexDirection( FlexDirection.ROW );
		for (int i = 0; i< 100; i++){
			final int index = i;
			Button testButton = new Button( String.valueOf( index) );
			testButtonContainer.add( testButton );
			if (index % 2 == 0){
				PopoverTooltip.createOrRenew(testButton, "<span>" +"testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest"+ index  + "</span>"  );
			} else {
				testButton.setTooltipText( "Standard Tooltip" );
			}
//			testButton.getStyle().setMaxWidth( "1rem" );
//			testButton.getStyle().setMaxHeight( "1rem" );

//			testButton.addClickListener( event -> {
//				Div testButtonDiv = new Div();
//				testButtonDiv.add( new Span( "Test Button " + index + " clicked" ) );
//				testButtonContainer.add( testButtonDiv );
//			} );
		}
		add( testButtonContainer );
		
		
		
	}
	
	
}
