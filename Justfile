ADB := "$HOME/Android/Sdk/platform-tools/adb"
PACKAGE := "com.example.healthcalculatorkotlin"

screenshot file="screenshot.png":
    {{ADB}} shell screencap -p /sdcard/{{file}}
    {{ADB}} pull /sdcard/{{file}} {{file}}

launch:
    {{ADB}} shell am start -n {{PACKAGE}}/.MainActivity

monkey events="500": launch
    {{ADB}} shell monkey -p {{PACKAGE}} -v \
        --pct-touch 60 \
        --pct-motion 40 \
        --pct-syskeys 0 \
        --pct-appswitch 0 \
        --pct-majornav 0 \
        --pct-nav 0 \
        --throttle 50 \
        {{events}}

monkey-screenshot events="500" file="monkey_result.png":
    just monkey {{events}} || true
    just screenshot {{file}}
