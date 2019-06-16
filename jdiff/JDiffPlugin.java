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
import org.gjt.sp.jedit.jEdit;
import org.gjt.sp.jedit.msg.PropertiesChanged;
import org.gjt.sp.util.SyntaxUtilities;

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
    overviewChangedColor = SyntaxUtilities.parseColor(jEdit.getProperty( "jdiff.overview-changed-color", "#FFCC66" ), Color.decode("#FFCC66"));
    overviewDeletedColor = SyntaxUtilities.parseColor(jEdit.getProperty( "jdiff.overview-deleted-color", "#FF6666" ), Color.decode("#FF6666"));
    overviewInsertedColor = SyntaxUtilities.parseColor(jEdit.getProperty( "jdiff.overview-inserted-color", "#99CC66" ), Color.decode("#99CC66"));
    overviewInvalidColor = SyntaxUtilities.parseColor(jEdit.getProperty( "jdiff.overview-invalid-color", "#CCCCCC" ), Color.decode("#CCCCCC"));
    leftCursorColor = jEdit.getColorProperty( "jdiff.left-cursor-color", jEdit.getColorProperty( "view.caretColor", Color.BLACK ) );
    rightCursorColor = jEdit.getColorProperty( "jdiff.right-cursor-color", jEdit.getColorProperty( "view.caretColor", Color.BLACK ) );
    
    // funa edit
    // Highlight colors
    highlightChangedColor = SyntaxUtilities.parseColor(jEdit.getProperty( "jdiff.highlight-changed-color", "#FFFF90" ), Color.decode("#FFFF90"));
    highlightDeletedColor = SyntaxUtilities.parseColor(jEdit.getProperty( "jdiff.highlight-deleted-color", "#FF9090" ), Color.decode("#FF9090"));
    highlightInsertedColor = SyntaxUtilities.parseColor(jEdit.getProperty( "jdiff.highlight-inserted-color", "#D9FF90" ), Color.decode("#D9FF90"));
    highlightInvalidColor = SyntaxUtilities.parseColor(jEdit.getProperty( "jdiff.highlight-invalid-color", "#909090" ), Color.decode("#909090"));
  }
}
