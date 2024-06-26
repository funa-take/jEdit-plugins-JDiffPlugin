/*
* JDiffPlugin.java
* Copyright (c) 2000, 2001, 2002 Andre Kaplan
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; either version 2
* of the License, or any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/


package jdiff;

import java.awt.Color;

import org.gjt.sp.jedit.EBMessage;
import org.gjt.sp.jedit.EBPlugin;
import org.gjt.sp.jedit.GUIUtilities;
import org.gjt.sp.jedit.jEdit;
import org.gjt.sp.jedit.msg.PropertiesChanged;

import jdiff.util.DualDiffUtil;

public class JDiffPlugin extends EBPlugin {

    public static Color overviewChangedColor;
    public static Color overviewDeletedColor;
    public static Color overviewInsertedColor;
    public static Color overviewInvalidColor;
    public static Color leftCursorColor;
    public static Color rightCursorColor;

  // funa edit
  public static Color highlightChangedColor;
  public static Color highlightDeletedColor;
  public static Color highlightInsertedColor;
  public static Color highlightInvalidColor;
  
    static {
        propertiesChanged();
    }


    public JDiffPlugin() {
        super();
    }


    public void start() {}

    public void stop() {}

    public void handleMessage( EBMessage message ) {
        if ( message instanceof PropertiesChanged ) {
            DualDiffUtil.propertiesChanged();
            JDiffPlugin.propertiesChanged();
        }
    }

    public static void propertiesChanged() {
        // colors
        overviewChangedColor = GUIUtilities.parseColor(
      jEdit.getProperty("jdiff.overview-changed-color", "#FFCC66")
                );
        overviewDeletedColor = GUIUtilities.parseColor(
      jEdit.getProperty("jdiff.overview-deleted-color", "#FF6666")
                );
        overviewInsertedColor = GUIUtilities.parseColor(
      jEdit.getProperty("jdiff.overview-inserted-color", "#99CC66")
                );
        overviewInvalidColor = GUIUtilities.parseColor(
      jEdit.getProperty("jdiff.overview-invalid-color", "#CCCCCC")
                );
    
        leftCursorColor = jEdit.getColorProperty( "jdiff.left-cursor-color", jEdit.getColorProperty( "view.caretColor", Color.BLACK ) );
        rightCursorColor = jEdit.getColorProperty( "jdiff.right-cursor-color", jEdit.getColorProperty( "view.caretColor", Color.BLACK ) );
    
    // funa edit
    // Highlight colors
    highlightChangedColor = GUIUtilities.parseColor(
      jEdit.getProperty("jdiff.highlight-changed-color", "#FFFF90")
      );
    highlightDeletedColor = GUIUtilities.parseColor(
      jEdit.getProperty("jdiff.highlight-deleted-color", "#FF9090")
      );
    highlightInsertedColor = GUIUtilities.parseColor(
      jEdit.getProperty("jdiff.highlight-inserted-color", "#D9FF90")
      );
    
    highlightInvalidColor = GUIUtilities.parseColor(
      jEdit.getProperty("jdiff.highlight-invalid-color", "#909090")
      );
    }
}