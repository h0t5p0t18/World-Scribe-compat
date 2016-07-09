package com.averi.worldscribe.utilities;

import android.content.Context;
import android.os.Environment;

import com.averi.worldscribe.Category;
import com.averi.worldscribe.R;

import java.io.File;

/**
 * Created by mark on 14/06/16.
 */
public class FileRetriever {

    public static final String APP_DIRECTORY_NAME = "WorldScribe";
    public static final String SNIPPET_FILE_EXTENSION = ".txt";

    public static File getAppDirectory() {
        return new File(Environment.getExternalStorageDirectory(), APP_DIRECTORY_NAME);
    }

    public static File getWorldDirectory(String worldName) {
        return new File(getAppDirectory(), worldName);
    }

    public static File getCategoryDirectory(Context context, String worldName, Category category) {
        return new File(getWorldDirectory(worldName), category.pluralName(context));
    }

    public static File getArticleDirectory(Context context, String worldName, Category category,
                                           String articleName) {
        return new File(getCategoryDirectory(context, worldName, category), articleName);
    }

    public static File getArticleFile(Context context, String worldName, Category category,
                                      String articleName, String fileName) {
        return new File(getArticleDirectory(context, worldName, category, articleName),
                fileName);
    }

    public static File getConnectionsDirectory(Context context, String worldName, Category category,
                                               String articleName) {
        return new File(getArticleDirectory(context, worldName, category, articleName),
                context.getResources().getString(R.string.connectionsText));
    }

    public static File getConnectionCategoryDirectory(Context context, String worldName,
                                                      Category category, String articleName,
                                                      Category connectionCategory) {
        return new File(getConnectionsDirectory(context, worldName, category, articleName),
                connectionCategory.pluralName(context));
    }

    /**
     * Retrieve the folder containing all of an Article's Snippets.
     * @param context The Context calling this method.
     * @param worldName The name of the current World.
     * @param category The {@link Category} of the current Article.
     * @param articleName The name of the current Article.
     * @return A File referring to the specified Article's Snippets directory.
     */
    public static File getSnippetsDirectory(Context context, String worldName, Category category,
                                            String articleName) {
        return new File(getArticleDirectory(context, worldName, category, articleName),
                context.getResources().getString(R.string.snippetsText));
    }

    /**
     * Retrieve a Snippet's file.
     * @param context The Context calling this method.
     * @param worldName The name of the current World.
     * @param category The {@link Category} of Article the Snippet belongs to.
     * @param articleName The name of the Article the Snippet belongs to.
     * @param snippetName The name of the Snippet being loaded.
     * @return A File referencing the specified Snippet.
     */
    public static File getSnippetFile(Context context, String worldName, Category category,
                                      String articleName, String snippetName) {
        return new File(getSnippetsDirectory(context, worldName, category, articleName),
                snippetName + SNIPPET_FILE_EXTENSION);
    }
}
