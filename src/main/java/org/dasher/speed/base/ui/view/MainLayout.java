package org.dasher.speed.base.ui.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.popover.PopoverPosition;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.server.menu.MenuConfiguration;
import com.vaadin.flow.server.menu.MenuEntry;
import static com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import static com.vaadin.flow.theme.lumo.LumoUtility.Display;
import static com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import static com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import static com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin.Horizontal;
import static com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import org.dasher.speed.base.ui.component.PopoverTooltip;


@Layout
public final class MainLayout extends AppLayout {
	
	public MainLayout() {
		setPrimarySection( Section.DRAWER );
		addToDrawer( createHeader(), new Scroller( createSideNav() ) );
	}
	
	private Div createHeader() {
		var appName = new Span( "Feature Request Economed" );
		appName.addClassNames( FontWeight.SEMIBOLD, FontSize.LARGE );
		var header = new Div( appName );
		header.addClassNames( Display.FLEX, Padding.MEDIUM, Gap.MEDIUM, AlignItems.CENTER );
		return header;
	}
	
	private SideNav createSideNav() {
		var nav = new SideNav();
		nav.addClassNames( Horizontal.MEDIUM );
		MenuConfiguration.getMenuEntries().forEach( entry -> nav.addItem( createSideNavItem( entry ) ) );
		return nav;
	}
	
	private SideNavItem createSideNavItem( MenuEntry menuEntry ) {
		SideNavItem item;
		if( menuEntry.icon() != null ) {
			item = new SideNavItem( menuEntry.title(), menuEntry.path(), new Icon( menuEntry.icon() ) );
		}
		else {
			item = new SideNavItem( menuEntry.title(), menuEntry.path() );
		}
		var tt = PopoverTooltip.createOrRenew( item, "<span>Location: <b>" + menuEntry.path() + "</b></span>" );
		tt.setPosition( PopoverPosition.END );
		return item;
	}
	
}
