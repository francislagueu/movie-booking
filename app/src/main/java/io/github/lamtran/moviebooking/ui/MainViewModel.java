/*
 * MIT License
 *
 * Copyright (c) 2017 Lam Tran (tranngoclam288@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.lamtran.moviebooking.ui;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import javax.inject.Inject;

import io.github.lamtran.moviebooking.R;
import io.github.lamtran.moviebooking.di.ActivityScope;
import io.github.lamtran.moviebooking.model.Seat;
import io.github.lamtran.moviebooking.util.AppUtils;
import io.github.lamtran.moviebooking.util.Toaster;

/**
 * Created by lam on 2/3/17.
 */

@ActivityScope public class MainViewModel extends BaseObservable {

  public final ObservableField<SeatAdapter> adapter = new ObservableField<>();

  public final ObservableList<Seat> seats = new ObservableArrayList<>();

  private final Toaster mToaster;

 @Inject public MainViewModel(Toaster toaster, SeatAdapter adapter) {
    mToaster = toaster;
    adapter.setOnMaxSelectionReachedListener(() -> mToaster.showShortToast(R.string.max_selection_reached, AppUtils.MAX_SELECTION));
    adapter.setMaxSelection(AppUtils.MAX_SELECTION);
    this.adapter.set(adapter);
    this.seats.clear();
    this.seats.addAll(AppUtils.fakeSeats());
  }
}
