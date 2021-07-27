# BottomSheet

 1. BottomSheetDialog
 2. BottomSheetDialog (fragment)
 3. BottomSheetBehavior

# Requirements
- CoordinatorLayout (Essential)
- Kotlin 1.5.10
- Gradle 4.2.1
- Android min SDK 28
- Android target SDK 30
- etc

# Installation

- gradle(:app)
```
dependencies {
	...
    implementation 'com.google.android.material:material:1.4.0'
	...
}
```

# Behavior 속성
app:layout_behavior로 BottomSheetBehavior를 설정했다면, XML에서 속성 설정 가능
java(kotlin)코드로 설정하는 방법도 있음

- behavior_hideable : 아래로 드래그했을 때 뷰를 숨길지 여부를 결정합니다. DialogBottomSheet의 경우의 기본값은 true이고 그 외의 경우 기본값은 false입니다 (본 글에서 기본값은 false)
- behavior_skipCollapsed: 뷰를 숨길 때 접히는 상태를 무시할 지 여부를 결정합니다. 기본값은 false이며 behavior_hideable이 false라면 효과가 없습니다.
- behavior_draggable : 드래그하여 뷰를 접을 지 펼칠 지 여부를 결정합니다. 기본값은 true입니다.
- behavior_fitToContents: 펼쳐진 뷰의 높이가 content를 감쌀 것인지의 여부를 결정합니다. false로 설정하게 되면 뷰가 펼쳐졌을 때 아래로 드래그할 경우 부모 컨테이너 높이의 절반으로 먼저 접히고 다시 드래그 하면 완전히 접혀집니다. 기본값은 true입니다.
- behavior_halfExpandedRatio : 절반만 펼쳐졌을 경우 뷰의 높이를 결정합니다. 기본값은 0.5입니다. behavior_fitToContents 가 true라면 효과가 없습니다.
- behavior_expandedOffset : 완전히 펼쳐진 상태일 때 뷰의 오프셋을 결정합니다. 마찬가지로 behavior_fitToContents 가 true라면 효과가 없으며 절반으로 접혔을 경우의 오프셋보다 커야합니다. 기본값은 0dp입니다.
- behavior_peekHeight : 뷰가 접힌 상태의 높이입니다. 기본값은 auto입니다.


# Behavior State
BottomSheetBehavior.STATE_EXPANDED 

 - STATE_EXPANDED : 완전히 펼쳐진 상태
 - STATE_COLLAPSED : 접혀있는 상태
 - STATE_HIDDEN : 아래로 숨겨진 상태 (보이지 않음)
 - STATE_HALF_EXPANDED : 절반으로 펼쳐진 상태
 - STATE_DRAGGING : 드래깅되고 있는 상태
 - STATE_SETTLING : 드래그/스와이프 직후 고정된 상태
 
# Behavior 상태 저장
BottomSheetBehavior 로 설정된 뷰가 파괴되고 다시 생성되는 경우 유지할 속성들을 다음과 같은 옵션들에서 선택하여 유지할 수 있습니다.

behavior.saveFlags = BottomSheetBehavior.SAVE_FIT_TO_CONTENTS

- SAVE_PEEK_HEIGHT : behavior_peekHeight 속성 유지
- SAVE_HIDEABLE : behavior_hideable 속성 유지
- SAVE_SKIP_COLLAPSED : behavior_skipCollapsed 속성 유지
- SAVE_FIT_TO_CONTENTS : behavior_fitToContents 속성 유지
- SAVE_ALL : 모든 속성 유지
- SAVE_NONE : 기본값. 모든 속성 보존 X

# Description
세가지(Collapsed, HalfExtended, Extended)를 모두 사용하고 싶으면 
```
app:behavior_skipCollapsed = "true"
app:behavior_fitToContents = "false"
app:behavior_expandedOffset = "100dp"
```
두가지만 사용하면서 최대 높이를 조절하고 싶으면
```
android:layout_height="500dp"
app:behavior_peekHeight = "200dp"
```
이런식으로 사용하면 된다
